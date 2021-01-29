package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebButtonCode extends JWebEleJSCode {

	public JWebButtonCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(String text){
		return inflator("Button", text);
	}
	public String inflate(String text,String type){
		return inflator("Button", text, type);
	}
	
	public String create(String text){
		return constructor("Button", text);
	}
	public String create(String text,String type){
		return constructor("Button", text, type);
	}
	
	public String setWidth(String width){
		return codeFormat("setWidth", width);
	}
	public String removeClickHandler(){
		return codeFormat("removeClickHandler");
	}
	public String setClickHandler(EventHandler eventHandler){
		return codeFormat("setClickHandler", eventHandler);
	}
}
