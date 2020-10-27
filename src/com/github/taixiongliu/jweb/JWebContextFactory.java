package com.github.taixiongliu.jweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
}
