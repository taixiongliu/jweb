package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebIconLabelCode extends JWebEleJSCode{
	public JWebIconLabelCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String inflate(JSObject opts){
		return inflator("IconLabel", opts);
	}
	public String create(JSObject opts){
		return constructor("IconLabel", opts);
	}
}
