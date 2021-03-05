package com.github.taixiongliu.jweb;

public class Session {
	private int id;
	private AuthorizationInfo entity;
	private String sessionCode;
	private String tokenCode;
	public Session(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}
	public Session(int id, AuthorizationInfo entity, String sessionCode) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.entity = entity;
		this.sessionCode = sessionCode;
	}
	
	public int getId() {
		return id;
	}
	public AuthorizationInfo getEntity() {
		return entity;
	}
	public void setEntity(AuthorizationInfo entity) {
		this.entity = entity;
	}
	public String getSessionCode() {
		return sessionCode;
	}
	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}
	public String getTokenCode() {
		return tokenCode;
	}
	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	public String toSessionId(){
		return id+"_"+sessionCode;
	}
}
