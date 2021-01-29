package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebMenuLabelCode extends JWebEleJSCode{

	public JWebMenuLabelCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(JSObject opts){
		return inflator("MenuLabel", opts);
	}
	public String create(JSObject opts){
		return constructor("MenuLabel", opts);
	}
	public String setText(String text){
		return codeFormat("setText", text);
	}
	public String showChildren(){
		return codeFormat("showChildren");
	}
	public String hideChildren(){
		return codeFormat("hideChildren");
	}
	public String addChild(JSObject child){
		return codeFormat("addChild", child);
	}
}
