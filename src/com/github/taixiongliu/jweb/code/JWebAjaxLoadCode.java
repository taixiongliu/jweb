package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebAjaxLoadCode extends JWebEleJSCode {

	public JWebAjaxLoadCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(){
		return inflator("AjaxLoad");
	}
	public String create(){
		return constructor("AjaxLoad");
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
}
