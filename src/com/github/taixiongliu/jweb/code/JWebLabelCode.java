package com.github.taixiongliu.jweb.code;

public class JWebLabelCode extends JWebEleJSCode{
	public JWebLabelCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(String text){
		return constructor("Label", text);
	}
	public String create(String text, String style){
		return constructor("Label", text, style);
	}
}
