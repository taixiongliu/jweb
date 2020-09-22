package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;

public class JWebView extends JWeb{
	private String name;
	public JWebView(JWebContext context,String name) {
		// TODO Auto-generated constructor stub
		super(context);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Expression getExpression(){
		return new Expression(name);
	}
}
