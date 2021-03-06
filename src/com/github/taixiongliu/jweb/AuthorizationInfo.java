package com.github.taixiongliu.jweb;

import java.util.concurrent.ConcurrentHashMap;

import com.github.taixiongliu.jweb.enums.UserType;

public class AuthorizationInfo {
	private int id;
	private String name;
	private String account;
	private String passwd;
	private UserType userType;
	private boolean able;
	private ConcurrentHashMap<String, Object> properties;
	public AuthorizationInfo() {
		// TODO Auto-generated constructor stub
		properties = new ConcurrentHashMap<String, Object>();
	}
	
	public void setProperty(String key, Object value){
		properties.put(key, value);
	}
	public Object getProperty(String key){
		return properties.get(key);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public boolean isAble() {
		return able;
	}
	public void setAble(boolean able) {
		this.able = able;
	}
}
