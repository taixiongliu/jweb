package com.github.taixiongliu.jweb.code.utils;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebCode;
import com.github.taixiongliu.jweb.handler.AjaxCallbackHandler;

public class JWebAjaxCode extends JWebCode{

	public JWebAjaxCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Utils.Ajax");
	}
	
	public String setMethod(String method){
		return codeFormat("setMethod", method);
	}
	public String setParameter(String parameter){
		return codeFormat("setParameter", parameter);
	}
	public String setParameter(Expression parameter){
		return codeFormat("setParameter", parameter);
	}
	public String setSynchronization(boolean syn){
		return codeFormat("setSynchronization", syn);
	}
	public String request(String url, AjaxCallbackHandler handler){
		return codeFormat("request", url, handler);
	}
}
