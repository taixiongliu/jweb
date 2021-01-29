package com.github.taixiongliu.jweb.code.base;

import com.github.taixiongliu.jweb.base.JSBase;

public class JWebBaseCode extends JWebCode{
	private JSBase base;
	public JWebBaseCode(String name) {
		// TODO Auto-generated constructor stub
		this(name, null);
	}
	public JWebBaseCode(String name, Object value) {
		// TODO Auto-generated constructor stub
		super(name);
		base = new JSBase(name, value);
	}
	
	public String inflate(){
		return base.getValueCode();
	}
	public String create(){
		return base.getCode();
	}
	public String getName(){
		return name;
	}
	public Object getValue() {
		return base.getValue();
	}
	
}
