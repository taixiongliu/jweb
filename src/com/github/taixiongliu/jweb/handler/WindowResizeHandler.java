package com.github.taixiongliu.jweb.handler;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebContext;

public abstract class WindowResizeHandler extends BaseHandler{
	public WindowResizeHandler(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, "width,height");
	}
	public WindowResizeHandler(JWebContext context, JSBase... properties) {
		// TODO Auto-generated constructor stub
		super(context, "width,height", properties);
	}
	
	
	public Expression getWidth(){
		return new Expression("width");
	}
	public Expression getHeight(){
		return new Expression("height");
	}
}
