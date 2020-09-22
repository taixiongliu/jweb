package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebElementCode;

public class JWebElement extends JWebView{
	private JWebElementCode elementCode;
	
	private JWebElement(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	private void initView(){
		elementCode = new JWebElementCode(getName());
	}
	private void createById(String id){
		context.e(elementCode.createById(id));
	}
	
	public static JWebElement getElementById(JWebContext context, String id){
		JWebElement element = new JWebElement(context);
		element.createById(id);
		return element;
	}
	
	public void appendChild(JWebEleJSView view){
		context.e(elementCode.appendChild(view.getEle()));
	}
}
