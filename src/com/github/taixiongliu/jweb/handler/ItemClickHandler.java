package com.github.taixiongliu.jweb.handler;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebContext;

public abstract class ItemClickHandler extends BaseHandler{
	public ItemClickHandler(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, "data");
	}
	public ItemClickHandler(JWebContext context, JSBase... properties) {
		// TODO Auto-generated constructor stub
		super(context, "data", properties);
	}
	public Expression getValue(String opt){
		return new Expression("data."+opt);
	}
}
