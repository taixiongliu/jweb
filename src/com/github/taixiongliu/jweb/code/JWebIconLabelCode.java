package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.JSObject;

public class JWebIconLabelCode extends JWebEleJSCode{
	public JWebIconLabelCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(JSObject opts){
		return constructor("IconLabel", opts);
	}
}
