package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebCButtonCode extends JWebEleJSCode {

	public JWebCButtonCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public String create(String sstyle,String estyle){
		return constructor("CButton", sstyle, estyle);
	}
	public String removeClickHandler(){
		return codeFormat("removeClickHandler");
	}
	public String setClickHandler(EventHandler eventHandler){
		return codeFormat("setClickHandler", eventHandler);
	}
}
