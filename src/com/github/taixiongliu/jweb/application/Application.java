package com.github.taixiongliu.jweb.application;

import com.github.taixiongliu.jweb.AuthorizationInfo;
import com.github.taixiongliu.jweb.Session;

public class Application {
	private static Application server = null;
	private ApplicationAuth loginAuth;
	public static Application getInstance(){
		if(server != null){
			return server;
		}
		synchronized (Application.class) {
			if(server == null){
				server = new Application();
			}
		}
		return server;
	}
	private Application() {
		// TODO Auto-generated constructor stub
		loginAuth = new ApplicationAuth();
	}
	public void addAuth(String name, String code){
		loginAuth.add(name, code);
	}
	public String getAuth(String name){
		return loginAuth.get(name);
	}
	public Session createSession(AuthorizationInfo info){
		return loginAuth.createSession(info.getId(), info);
	}
	public void removeSession(int uid){
		loginAuth.removeSession(uid);
	}
	public void removeSession(String sid){
		loginAuth.removeSession(sid);
	}
	public Session getSession(String sessionId){
		return loginAuth.getSession(sessionId);
	}
	
	public void print(){
		loginAuth.printAuth();
		System.out.println("==========divider==========");
		loginAuth.printSession();
	}
}
