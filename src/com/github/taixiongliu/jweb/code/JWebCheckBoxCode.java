package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebCheckBoxCode extends JWebEleJSCode {

	public JWebCheckBoxCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(){
		return inflator("CheckBox");
	}
	
	public String create(){
		return constructor("CheckBox");
	}
}
