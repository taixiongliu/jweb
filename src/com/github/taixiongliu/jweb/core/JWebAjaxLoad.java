package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebAjaxLoadCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;

public class JWebAjaxLoad extends JWebEleJSView{
	private JWebAjaxLoadCode ajaxLoadCode;
	public JWebAjaxLoad(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, context.named(), false);
	}
	public JWebAjaxLoad(JWebContext context, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		if(inflate){
			inflateView();
			return ;
		}
		initView();
	}
	private void initView(){
		ajaxLoadCode = new JWebAjaxLoadCode(getName());
		context.e(ajaxLoadCode.create());
	}
	private void inflateView(){
		ajaxLoadCode = new JWebAjaxLoadCode(getName());
		context.e(ajaxLoadCode.inflate());
	}
	public static JWebAjaxLoad inflate(JWebContext context, String name){
		return new JWebAjaxLoad(context, name, true);
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
