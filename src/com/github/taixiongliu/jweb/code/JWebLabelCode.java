package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebLabelCode extends JWebEleJSCode{
	public JWebLabelCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String inflate(String text){
		return inflator("Label", text);
	}
	public String inflate(String text,String style){
		return inflator("Label", text, style);
	}
	public String create(String text){
		return constructor("Label", text);
	}
	public String create(String text, String style){
		return constructor("Label", text, style);
	}
}
