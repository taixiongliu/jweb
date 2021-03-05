package com.github.taixiongliu.jweb.handler;

import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebContext;

public abstract class ClickHandler extends BaseHandler{

	public ClickHandler(JWebContext context) {
		super(context, null);
		// TODO Auto-generated constructor stub
	}
	public ClickHandler(JWebContext context, JSBase... properties) {
		// TODO Auto-generated constructor stub
		super(context, "", properties);
	}

}
