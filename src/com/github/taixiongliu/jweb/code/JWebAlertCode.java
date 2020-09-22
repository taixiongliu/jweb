package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebAlertCode extends JWebEleJSCode {

	public JWebAlertCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String create(){
		return constructor("Alert");
	}
	
	public String setMsg(String msg){
		return codeFormat("setMsg", msg);
	}
	public String setMsg(Expression expression){
		return codeFormat("setMsg", expression);
	}
	public String show(){
		return codeFormat("show");
	}
	public String hide(){
		return codeFormat("hide");
	}
	public String setSureHandler(EventHandler eventHandler){
		return codeFormat("setSureHandler", eventHandler);
	}
}
