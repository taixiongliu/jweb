package com.github.taixiongliu.jweb.core.base;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.core.JWebContext;

public class JWebEleJSView extends JWebView{
	private Expression ele;
	
	public JWebEleJSView(JWebContext context,String name) {
		super(context, name);
		// TODO Auto-generated constructor stub
		this.ele = new Expression(name+".ele");
		
	}
	public Expression getEle(){
		return ele;
	}
}
