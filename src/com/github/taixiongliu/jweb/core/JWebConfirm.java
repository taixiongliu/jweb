package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebConfirmCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebConfirm extends JWebEleJSView{
	private JWebConfirmCode confirmCode;
	public JWebConfirm(JWebContext context) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView();
	}
	private void initView(){
		confirmCode = new JWebConfirmCode(getName());
		context.e(confirmCode.create());
	}
	
	public void setMsg(String msg){
		context.e(confirmCode.setMsg(msg));
	}
	public void setMsg(Expression expression){
		context.e(confirmCode.setMsg(expression));
	}
	public void show(){
		context.e(confirmCode.show());
	}
	public void hide(){
		context.e(confirmCode.hide());
	}
	public void setSureHandler(ItemClickHandler handler){
		context.e(confirmCode.setSureHandler(handler));
	}
	public void setCancelHandler(ItemClickHandler handler){
		context.e(confirmCode.setCancelHandler(handler));
	}
}
