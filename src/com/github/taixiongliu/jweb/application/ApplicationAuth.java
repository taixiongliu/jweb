package com.github.taixiongliu.jweb.application;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.github.taixiongliu.jweb.Session;

public class ApplicationAuth {
	private Map<String, String> authMap;
	private Map<Integer, Session> sessionMap;
	private Random random;
	//components
	public ApplicationAuth() {
		// TODO Auto-generated constructor stub
		//服务端验证码业务组件,考虑并发情况
		authMap = new ConcurrentHashMap<String, String>();
		sessionMap = new ConcurrentHashMap<Integer, Session>();
		random = new Random();
	}
	
	private String getRandom(int length){
		char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i ++){
			sb.append(arr[random.nextInt(arr.length)]);
		}
		return sb.toString();
	}
	
	/**
	 * 创建session
	 * @param uid
	 * @return
	 */
	public Session createSession(int uid,Object entity){
		String str = getRandom(20);
		Session session = new Session(uid, entity, str);
		session.setTokenCode(getRandom(6));
		sessionMap.put(uid, session);
		return session;
	}
	
	/**
	 * 通过ID移除session
	 * @param uid
	 */
	public void removeSession(int uid){
		sessionMap.remove(uid);
	}
	
	/**
	 * 通过session移除
	 * @param sid
	 */
	public void removeSession(String sid){
		Session session = getSession(sid);
		if(session != null){
			sessionMap.remove(session.getId());
		}
	}
	
	/**
	 * 获取注册的登录认证信息
	 * @param sessionId
	 * @return
	 */
	public Object getEntity(String sessionId){
		if(sessionId == null){
			return null;
		}
		if(!sessionId.contains("_")){
			return null;
		}
		String[] arr = sessionId.split("_");
		int uid = 0;
		try {
			uid = Integer.parseInt(arr[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(uid < 1 || arr.length != 2){
			return null;
		}
		Session session = sessionMap.get(uid);
		if(session == null){
			return null;
		}
		if(!arr[1].equals(session.getSessionCode())){
			return null;
		}
		return session.getEntity();
	}
	
	/**
	 * 获取对应session
	 * @param sessionId
	 * @return
	 */
	public Session getSession(String sessionId){
		if(sessionId == null){
			return null;
		}
		if(!sessionId.contains("_")){
			return null;
		}
		String[] arr = sessionId.split("_");
		int uid = 0;
		try {
			uid = Integer.parseInt(arr[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(uid < 1 || arr.length != 2){
			return null;
		}
		Session session = sessionMap.get(uid);
		if(session == null){
			return null;
		}
		if(!arr[1].equals(session.getSessionCode())){
			return null;
		}
		return session;
	}
	
	/**
	 * 添加一个验证码认证空间
	 * @param name
	 * @param code
	 */
	public void add(String name, String code){
		authMap.put(name, code);
	}
	
	/**
	 * 获取指定用户名的验证码
	 * @param name
	 * @return
	 */
	public String get(String name){
		return authMap.get(name);
	}
	
	public void printAuth(){
		for(String key : authMap.keySet()){
			System.out.println(key+":"+authMap.get(key));
		}
	}
	public void printSession(){
		for(Integer key : sessionMap.keySet()){
			System.out.println(key+":"+sessionMap.get(key).getSessionCode()+"&"+sessionMap.get(key).getTokenCode());
		}
	}
}
