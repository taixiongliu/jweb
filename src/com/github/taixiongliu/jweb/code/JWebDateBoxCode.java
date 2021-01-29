package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebDateBoxCode extends JWebEleJSCode {

	public JWebDateBoxCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(){
		return inflator("DateBox");
	}
	public String create(){
		return constructor("DateBox");
	}
	
	public String setSelectUpdateHandler(EventHandler handler){
		return codeFormat("setSelectUpdateHandler", handler);
	}
	public String removeSelectUpdateHandler(){
		return codeFormat("removeSelectUpdateHandler");
	}
	public String setPageUpdateHandler(EventHandler handler){
		return codeFormat("setPageUpdateHandler", handler);
	}
	public String removePageUpdateHandler(){
		return codeFormat("removePageUpdateHandler");
	}
	public String getSelectDateString(){
		return codeFormat("getSelectDateString");
	}
	public String previousMonth(){
		return codeFormat("previousMonth");
	}
	public String previousYear(){
		return codeFormat("previousYear");
	}
	public String nextMonth(){
		return codeFormat("nextMonth");
	}
	public String nextYear(){
		return codeFormat("nextYear");
	}
	public String showBelowLeft(Expression expression){
		return codeFormat("showBelowLeft", expression);
	}
	public String hide(){
		return codeFormat("hide");
	}
	public String show(String left, String top){
		return codeFormat("show", left, top);
	}
}
