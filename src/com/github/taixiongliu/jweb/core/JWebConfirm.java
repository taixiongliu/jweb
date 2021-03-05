package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebConfirmCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebConfirm extends JWebEleJSView{
	private JWebConfirmCode confirmCode;
	public JWebConfirm(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, context.named(), false);
	}
	public JWebConfirm(JWebContext context, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		confirmCode = new JWebConfirmCode(getName());
		if(inflate){
			inflateView();
			return ;
		}
		initView();
	}
	private void initView(){
		context.e(confirmCode.create());
	}
	private void inflateView(){
		context.e(confirmCode.inflate());
	}
	public static JWebConfirm inflate(JWebContext context, String name){
		return new JWebConfirm(context, name, true);
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
