package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebAjaxLoadCode;

public class JWebAjaxLoad extends JWebEleJSView{
	private JWebAjaxLoadCode ajaxLoadCode;
	public JWebAjaxLoad(JWebContext context) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView();
	}
	private void initView(){
		ajaxLoadCode = new JWebAjaxLoadCode(getName());
		context.e(ajaxLoadCode.create());
	}
	
	public void setMsg(String msg){
		context.e(ajaxLoadCode.setMsg(msg));
	}
	public void setMsg(Expression expression){
		context.e(ajaxLoadCode.setMsg(expression));
	}
	public void show(){
		context.e(ajaxLoadCode.show());
	}
	public void hide(){
		context.e(ajaxLoadCode.hide());
	}
}
