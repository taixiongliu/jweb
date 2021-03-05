package com.github.taixiongliu.jweb.core.base;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebContext;

public class JWebView extends JWeb{
	private String name;
	private JSBase base;
	public JWebView(JWebContext context,String name) {
		// TODO Auto-generated constructor stub
		super(context);
		if(name == null || name.trim().equals("")){
			name = context.named();
		}else{
			this.name = name;
		}
		base = new JSBase(name, this);
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
	
	public JSBase base(){
		return base;
	}
}
