package com.github.taixiongliu.jweb.handler;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebContext;

public abstract class MenuListItemHandler extends BaseHandler{
	public MenuListItemHandler(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, "obj");
	}
	public MenuListItemHandler(JWebContext context, JSBase... properties) {
		// TODO Auto-generated constructor stub
		super(context, "obj", properties);
	}
	
	public Expression getValue(String opt){
		return new Expression("obj."+opt);
	}
}
