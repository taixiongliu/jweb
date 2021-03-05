package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebAlertCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebAlert extends JWebEleJSView{
	private JWebAlertCode alertCode;
	public JWebAlert(JWebContext context) {
		this(context, context.named(), false);
	}
	public JWebAlert(JWebContext context, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		alertCode = new JWebAlertCode(getName());
		if(inflate){
			inflateView();
			return ;
		}
		initView();
	}
	private void initView(){
		context.e(alertCode.create());
	}
	private void inflateView(){
		context.e(alertCode.inflate());
	}
	public static JWebAlert inflate(JWebContext context, String name){
		return new JWebAlert(context, name, true);
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
