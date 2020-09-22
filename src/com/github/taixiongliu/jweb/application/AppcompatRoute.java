	package com.github.taixiongliu.jweb.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONObject;
import com.github.taixiongliu.hapi.http.HapiHttpRequest;
import com.github.taixiongliu.hapi.http.HapiHttpResponse;
import com.github.taixiongliu.hapi.route.HapiRouteType;
import com.github.taixiongliu.hapi.route.RequestMapping;
import com.github.taixiongliu.jweb.AuthorizationInfo;
import com.github.taixiongliu.jweb.ComponentBean;
import com.github.taixiongliu.jweb.JWebContextFactory;
import com.github.taixiongliu.jweb.Md5Util;
import com.github.taixiongliu.jweb.Session;

import io.netty.handler.codec.http.HttpHeaderNames;

public abstract class AppcompatRoute extends ApplicationRoute{
	public abstract Activity onCreatePage(ComponentBean bean, Session session);
	public abstract AuthorizationInfo getAuthorizationInfo(String account);
	public abstract boolean updatePassword(AuthorizationInfo info, String npasswd);
	
	@RequestMapping(value="index.html")
	public void jweb_index(HapiHttpRequest request, HapiHttpResponse response){
		Session session = getSession(request);
		if(session == null){
			response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "text/html");
			response.setContent(jweb_forwardHtml("login.html"));
			return ;
		}
		
		response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "text/html");
		int page = 0;
		Object obj = request.getParameter("page");
		if(obj != null){
			page = Integer.parseInt(obj.toString());
		}
		ComponentBean bean = JWebContextFactory.getInstance().getBean(page);
		if(bean == null){
			return ;
		}
		response.setContent(jweb_getHtml(bean,session.toSessionId()));
	}
	
	@RequestMapping(value="login.jweb")
	public void jweb_login(HapiHttpRequest request, HapiHttpResponse response){
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String authcode = request.getParameter("authcode");
		//参数不完整，均不可为空
		if(isAnyEmpty(account, passwd, authcode)){
			response.setContent(response(1001, "参数不完整"));
			return ;
		}
		AuthorizationInfo auth = getAuthorizationInfo(account);
		//账号不存在
		if(auth == null){
			response.setContent(response(1002, "账号不存在"));
			return ;
		}
		String nameCode = Application.getInstance().getAuth(account);
		//验证码未获取
		if(isEmpty(nameCode)){
			response.setContent(response(1003, "验证码无效"));
			return ;
		}
		//验证码错误
		if(!authcode.equals(nameCode)){
			response.setContent(response(1004, "验证码错误"));
			return ;
		}
		//账号未激活
		if(!auth.isAble()){
			response.setContent(response(1005, "账号未激活"));
			return ;
		}
		//密码错误
		if(!Md5Util.getMd5(passwd).equals(auth.getPasswd())){
			response.setContent(response(1006, "密码错误"));
			return ;
		}
		//缓存信息不缓存账号密码
		auth.setPasswd("");
		Session session = Application.getInstance().createSession(auth);
		JSONObject data = new JSONObject();
		data.put("sid", session.toSessionId());
		data.put("tcode", session.getTokenCode());
		response.setContent(response(1000, "", data));
		Application.getInstance().print();
	}
	
	@RequestMapping(value="upd_password.jweb")
	public void jweb_updPassword(HapiHttpRequest request, HapiHttpResponse response){
		String opasswd = request.getParameter("opasswd");
		String npasswd = request.getParameter("npasswd");
		Session session = getSession(request);
		if(session == null){
			response.setContent(response(403, "authorization disabled. #code:1"));
			return ;
		}
		//账号验证，没有缓存密码，需要重新获取账号信息
		AuthorizationInfo entity = (AuthorizationInfo)session.getEntity();
		System.out.println("缓存账号："+entity.getAccount());
		AuthorizationInfo temp = getAuthorizationInfo(entity.getAccount());
		if(temp == null){
			response.setContent(response(403, "authorization disabled. #code:2"));
			return ;
		}
		
		if(isEmpty(opasswd)){
			response.setContent(response(1001, "parameter error,code 1001."));
			return ;
		}
		if(isEmpty(npasswd)){
			response.setContent(response(1002, "parameter error,code 1002."));
			return ;
		}
		//密码验证
		if(!Md5Util.getMd5(opasswd).equals(temp.getPasswd())){
			response.setContent(response(1003, "原密码错误,code 1003."));
			return ;
		}
		
		boolean res = updatePassword(temp, Md5Util.getMd5(npasswd));
		if(!res){
			response.setContent(response(1004, "密码修改失败,code 1004."));
			return ;
		}
		//密码未缓存无需维护缓存实体
		
		response.setContent(response(1000, ""));
	}
	
	/**
	 * 登录劝退
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="logout.jweb")
	public void jweb_logout(HapiHttpRequest request, HapiHttpResponse response){
		String sid = request.getParameter("sid");
		if(!isEmpty(sid)){
			Application.getInstance().removeSession(sid);
		}
		response.setContent(response(1000, ""));
		Application.getInstance().print();
	}
	
	@RequestMapping(value="auth_name.jweb")
	public void jweb_authName(HapiHttpRequest request, HapiHttpResponse response){
		String account = request.getParameter("account");
		if(isEmpty(account)){
			response.setContent(response(1001, "请输入账号再获取验证码"));
			return ;
		}
		AuthorizationInfo auth = getAuthorizationInfo(account);
		if(auth == null){
			response.setContent(response(1002, "账号不存在"));
			return ;
		}
		response.setContent(response(1000, ""));
	}
	
	@RequestMapping(value="auth_code.jweb",type=HapiRouteType.FILE)
	public void jweb_authCode(HapiHttpRequest request, HapiHttpResponse response){
		String name = request.getParameter("name");
		if(isEmpty(name)){
			response.setContent("");
			return ;
		}
		AuthorizationInfo auth = getAuthorizationInfo(name);
		if(auth == null){
			response.setContent("");
			return ;
		}
		
		int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHead("Pragma", "No-cache");
        response.setHead("Cache-Control", "no-cache");
        response.setHead("Expires", "0");

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        //session.setAttribute("strCode", strCode);
        Application.getInstance().addAuth(name, strCode);
        g.dispose();

        String fileName = "tf/"+name+".jpg";
        FileOutputStream fos;
		try {
			File path = new File("tf");
			if(!path.exists()){
				path.mkdir();
			}
			File file = new File(fileName);
			if(file.exists()){
				file.delete();
			}
			fos = new FileOutputStream(file);
			ImageIO.write(image, "JPEG", fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        response.setContent(fileName);
	}
	
	private Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
	
	@RequestMapping(value="index.js")
	public void jweb_indexJs(HapiHttpRequest request, HapiHttpResponse response){
		response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "application/javascript");
		//Object osid = request.getParameter("sid");
		Session session = getSession(request);
		if(session == null){
			//response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "text/html");
			response.setContent("authorization disabled.");
			return ;
		}
		
		int page = 0;
		Object obj = request.getParameter("page");
		Object pobj = request.getParameter("parameter");
		if(obj != null){
			page = Integer.parseInt(obj.toString());
		}
		if(pobj != null){
			System.out.println(pobj.toString());
		}
		
		ComponentBean bean = JWebContextFactory.getInstance().getBean(page);
		if(bean == null){
			response.setContent("page not exist.");
			return ;
		}
		
		if(isEmpty(bean.getActivity())){
			Activity activity = onCreatePage(bean, session);
			if(activity == null){
				response.setContent("404 activity not exist.");
				return ;
			}
			System.out.println(activity.getViewContent());
			response.setContent(activity.getViewContent());
			return ;
		}
		
		try {
			Class<?> clazz = Class.forName(bean.getActivity());
			Constructor<?> ct = clazz.getDeclaredConstructor(ComponentBean.class, Session.class);
			Activity activity = (Activity)ct.newInstance(bean, session);
			System.out.println(activity.getViewContent());
			response.setContent(activity.getViewContent());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String jweb_getHtml(ComponentBean bean, String sid){
		String res = "<!DOCTYPE html><html><head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\" />"
				+ "<meta http-equiv=\"Pragma\" content=\"no-cache\" />"
				+ "<meta name=\"Description\" content=\"\"/>"
				+ "<meta name=\"Keywords\" content=\"\"/>"
				+ "<title>"+bean.getTitle()+"</title>"
				+ "<script src=\"js/index.js\" type=\"text/javascript\" charset=\"utf-8\"></script>"
				+ "<script src=\"ele/ele.js\" type=\"text/javascript\" charset=\"utf-8\"></script>"
				+ "<script src=\"index.js?sid="+sid+"&page="+bean.getId()+"\" type=\"text/javascript\" charset=\"utf-8\"></script>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"ele/ele.css\"/>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\"/>"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>"
				+ "</head><body id=\"jweb_body\"></body></html>";
		
		return res;
	}
	
	private String jweb_forwardHtml(String page){
		String res = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title></title>"
		+"<script type=\"text/javascript\">"
		+"	window.location.href=\""+page+"\";"
		+"</script>"
	+"</head><body></body></html>";
		
		return res;
	}
	
	private Session getSession(HapiHttpRequest request){
		String sid = request.getParameter("sid");
		if(isEmpty(sid)){
			return null;
		}
		return Application.getInstance().getSession(sid);
	}
	
	/**
	 * 字符串判空
	 * @param str
	 * @return
	 */
	protected boolean isEmpty(String str){
		if(str == null || str.trim().equals("")){
			return true;
		}
		return false;
	}
	/**
	 * 是否存在空字符
	 * @param strs
	 * @return
	 */
	protected boolean isAnyEmpty(String... strs){
		if(strs == null || strs.length < 1){
			return true;
		}
		boolean res = false;
		for(String str : strs){
			if(isEmpty(str)){
				res = true;
				break;
			}
		}
		return res;
	}
	
	/**
	 * 接口错误信息返回数据
	 * @param code
	 * @param message
	 * @return
	 */
	protected final String response(int code, String message) {
		JSONObject jo = new JSONObject();
		jo.put("errorCode", code);
		jo.put("errorMsg", message);
		return jo.toJSONString();
	}
	protected final String response(int code, String message, JSONObject data) {
		JSONObject jo = new JSONObject();
		jo.put("errorCode", code);
		jo.put("errorMsg", message);
		jo.put("data", data);
		return jo.toJSONString();
	}
}
