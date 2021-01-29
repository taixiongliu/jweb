package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebICheckBoxCode extends JWebEleJSCode {

	public JWebICheckBoxCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(){
		return inflator("ICheckBox");
	}
	public String create(){
		return constructor("ICheckBox");
	}
	public String click(){
		return codeFormat("click");
	}
	public String checked(){
		return codeFormat("checked");
	}
	public String unChecked(){
		return codeFormat("unChecked");
	}
	public String isChecked(){
		return codeFormat("isChecked");
	}
	public String addClickEvent(EventHandler eventHandler){
		return codeFormat("addClickEvent", eventHandler);
	}
}
