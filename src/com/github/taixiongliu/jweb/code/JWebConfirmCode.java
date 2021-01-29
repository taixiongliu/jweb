package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebConfirmCode extends JWebEleJSCode {

	public JWebConfirmCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(){
		return inflator("Confirm");
	}
	public String create(){
		return constructor("Confirm");
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
	public String setCancelHandler(EventHandler eventHandler){
		return codeFormat("setCancelHandler", eventHandler);
	}
}
