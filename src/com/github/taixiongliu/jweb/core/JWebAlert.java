package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebAlertCode;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebAlert extends JWebEleJSView{
	private JWebAlertCode alertCode;
	public JWebAlert(JWebContext context) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView();
	}
	private void initView(){
		alertCode = new JWebAlertCode(getName());
		context.e(alertCode.create());
	}
	
	public void setMsg(String msg){
		context.e(alertCode.setMsg(msg));
	}
	public void setMsg(Expression expression){
		context.e(alertCode.setMsg(expression));
	}
	public void show(){
		context.e(alertCode.show());
	}
	public void hide(){
		context.e(alertCode.hide());
	}
	public void setSureHandler(ItemClickHandler handler){
		context.e(alertCode.setSureHandler(handler));
	}
}
