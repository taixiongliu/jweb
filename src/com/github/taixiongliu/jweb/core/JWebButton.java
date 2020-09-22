package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebButtonCode;
import com.github.taixiongliu.jweb.enums.ButtonType;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebButton extends JWebEleJSView{
	private JWebButtonCode buttonCode;
	public JWebButton(JWebContext context, String text) {
		this(context, text, null);
	}
	public JWebButton(JWebContext context, String text, ButtonType type) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView(text, type);
	}
	private void initView(String text, ButtonType type){
		buttonCode = new JWebButtonCode(getName());
		if(type == null){
			context.e(buttonCode.create(text));
			return ;
		}
		context.e(buttonCode.create(text,type.value()));
	}
	
	public void setWidth(String width){
		context.e(buttonCode.setWidth(width));
	}
	public void removeClickHandler(){
		context.e(buttonCode.removeClickHandler());
	}
	public void setClickHandler(ItemClickHandler handler){
		context.e(buttonCode.setClickHandler(handler));
	}
}
