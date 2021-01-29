package com.github.taixiongliu.jweb.core.base;

import com.github.taixiongliu.jweb.core.JWebContext;

public class JWeb{
	protected JWebContext context;
	public JWeb(JWebContext context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	public void setContext(JWebContext context){
		this.context = context;
	}
}
