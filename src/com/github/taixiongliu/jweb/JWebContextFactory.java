package com.github.taixiongliu.jweb;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import com.github.taixiongliu.hapi.dom.DOMParser;
import com.github.taixiongliu.jweb.handler.ListGridHandler.Field;

/**
 * <b>Scan annotation create and cache router instance</b>
 * @author taixiong.liu
 *
 */
public class JWebContextFactory {
	private static JWebContextFactory factory = null;
	private static Object look = new Object();
	public static JWebContextFactory getInstance(){
		if(factory != null){
			return factory;
		}
		synchronized (look) {
			if(factory == null){
				factory = new JWebContextFactory();
			}
		}
		return factory;
	}
	
	private List<ComponentBean> beans;
	private JWebContextFactory() {
		// TODO Auto-generated constructor stub
		beans = new ArrayList<ComponentBean>();
	}
	
	/**
	 * <b>create JWeb context</b>
	 * @param context configuration file name
	 */
	public void createContext(String context){
		DOMParser parser = new DOMParser();
		List<Map<String, String>> maps = parser.parseListMap(context);
		if(maps == null){
			return ;
		}
		for(Map<String, String> map : maps){
			ComponentBean bean = new ComponentBean();
			int id = 0;
			int pid = 0;
			try {
				id = Integer.parseInt(map.get("id"));
				pid = Integer.parseInt(map.get("pid"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(id < 0){
				continue;
			}
			bean.setId(id);
			bean.setPid(pid);
			bean.setTitle(map.get("title"));
			bean.setName(map.get("name"));
			bean.setMenuName(map.get("menuName"));
			bean.setActivity(map.get("activity"));
			bean.setIcon(map.get("icon"));
			beans.add(bean);
		}
		System.out.println("jweb component read "+beans.size()+" records.");
	}
	
	/**
	 * <b>create fields by context</b>
	 * @param context configuration file name
	 */
	public List<Field> createFields(String context){
		DOMParser parser = new DOMParser();
		List<Map<String, String>> maps = parser.parseListMap(context);
		if(maps == null){
			return null;
		}
		List<Field> fields = new ArrayList<Field>();
		for(Map<String, String> map : maps){
			String fieldName = map.get("fieldName");
			String textName = map.get("textName");
			Field bean = new Field(fieldName, textName);
			
			bean.setFieldWidth(map.get("fieldWidth"));
			fields.add(bean);
		}
		return fields;
	}

	public List<ComponentBean> getBeans() {
		return beans;
	}
	public ComponentBean getBean(int id){
		if(beans.isEmpty()){
			return null;
		}
		ComponentBean bean = null;
		for(ComponentBean temp : beans){
			if(temp.getId() == id){
				bean = temp;
				break;
			}
		}
		return bean;
	}
	
	/**
	 * <b> read jar file </b>
	 * @param clazz
	 * @param fileName
	 * @return
	 */
	public String readJarFile(Class<?> clazz, String fileName){
   		String jarPath = clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
        InputStream input = null;
        BufferedInputStream bis = null;
        JarFile jarFile = null;
        StringBuilder sb = new StringBuilder();
        try {
            jarFile = new JarFile(jarPath);
            ZipEntry zipEntry = jarFile.getEntry(fileName);
            //can not find the deserved file
            if (zipEntry == null) {
                System.out.println("Can not find file "+fileName);
                return null;
            }

            input = jarFile.getInputStream(zipEntry);
            bis = new BufferedInputStream(input);

            int buff = bis.available();
            //max memery buffer limit.
            if(buff > 1024000){
            	buff = 1024000;
            }
            
            byte[] temp = new byte[buff];
            int len = 0;
            while ((len = bis.read(temp)) != -1) {
            	sb.append(new String(temp, 0, len, StandardCharsets.UTF_8));
            }
        } catch (IOException ex) {
            throw new RuntimeException("A valid file "+fileName+" is unavailable.");
        } finally {
            if (bis != null) {
                try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            if (input != null) {
                try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if(jarFile != null){
           	 try {
					jarFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }

        return sb.toString();
   }
}
