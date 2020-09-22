package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;

public class JWebVLayoutCode extends JWebEleJSCode{
	public JWebVLayoutCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(){
		return constructor("VLayout");
	}
	public String create(String styleName){
		return constructor("VLayout", styleName);
	}
	public String addView(Expression ele, JSObject opts){
		if(opts == null){
			return codeFormat("add", ele);
		}
		return codeFormat("add", ele, opts);
	}
	public String setContainer(Expression ele){
		return codeFormat("setContainer", ele);
	}
	public String setContainerById(String id){
		return codeFormat("setContainerById", id);
	}
	public Expression getView(){
		return new Expression(name+".getView()"); 
	}
	public String clear(){
		return codeFormat("clear");
	}
}
