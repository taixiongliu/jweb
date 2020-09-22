package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;

public class JWebEleJSView extends JWebView{
	private Expression ele;
	private JSBase base;
	public JWebEleJSView(JWebContext context,String name) {
		super(context, name);
		// TODO Auto-generated constructor stub
		this.ele = new Expression(name+".ele");
		base = new JSBase(name, this);
	}
	public Expression getEle(){
		return ele;
	}
	
	public JSBase base(){
		return base;
	}
}
