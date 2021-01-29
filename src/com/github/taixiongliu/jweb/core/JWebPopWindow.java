package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebPopWindowCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;

public class JWebPopWindow extends JWebEleJSView{
	private JWebPopWindowCode popWindowCode;
	public JWebPopWindow(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	public JWebPopWindow(JWebContext context, int width, int height) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(width, height);
	}
	private void initView(){
		popWindowCode = new JWebPopWindowCode(getName());
		context.e(popWindowCode.create());
	}
	private void initView(int width, int height){
		popWindowCode = new JWebPopWindowCode(getName());
		context.e(popWindowCode.create(width, height));
	}
	public void setTitle(String title){
		context.e(popWindowCode.setTile(title));
	}
	
	public void show(){
		context.e(popWindowCode.show());
	}
	
	public void addView(JWebEleJSView view){
		context.e(popWindowCode.addView(view.getExpression()));
	}
	
	public void hide(){
		context.e(popWindowCode.hide());
	}
}
