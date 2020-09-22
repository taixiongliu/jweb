package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.JSBase;

public class JWebBasicCode extends JWebCode{
	private JSBase base;
	public JWebBasicCode(String name) {
		// TODO Auto-generated constructor stub
		this(name,"");
	}
	public JWebBasicCode(String name, Object value) {
		// TODO Auto-generated constructor stub
		super(name);
		base = new JSBase(name, value);
	}
	
	
	public String create(){
		return base.getValueCode();
	}
	public String getName(){
		return name;
	}
	public Object getValue() {
		return base.getValue();
	}
	
}
