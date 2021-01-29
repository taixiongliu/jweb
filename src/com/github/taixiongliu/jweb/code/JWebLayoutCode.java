package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebLayoutCode extends JWebEleJSCode{
	public JWebLayoutCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String inflate(){
		return inflator("Layout");
	}
	public String inflate(String style){
		return inflator("Layout", style);
	}
	public String create(){
		return constructor("Layout");
	}
	public String create(String style){
		return constructor("Layout", style);
	}
	public String setAlign(String align){
		return codeFormat("setAlign", align);
	}
	public String addView(Expression ele){
		return codeFormat("add", ele);
	}
	public String setContainer(Expression ele){
		return codeFormat("setContainer", ele);
	}
	public String setContainerById(String id){
		return codeFormat("setContainerById", id);
	}
	public String removeView(Expression ele){
		return codeFormat("remove", ele);
	}
	public String setHtml(String html){
		return codeFormat("setHtml", html);
	}
	public String clear(){
		return codeFormat("clear");
	}
	public Expression getHeight(){
		return new Expression("window.getComputedStyle("+name+".ele).height");
	}
	public String onClick(EventHandler eventHandler){
		return name+".ele.onclick="+eventHandler.toCode()+";";
	}
	public String setHeight(String height){
		return codeFormat("setHeight", height);
	}
}
