package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebButtonCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.enums.ButtonType;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebButton extends JWebEleJSView{
	private JWebButtonCode buttonCode;
	public JWebButton(JWebContext context, String text) {
		this(context, text, null);
	}
	public JWebButton(JWebContext context, String text, ButtonType type) {
		// TODO Auto-generated constructor stub
		this(context, text, type, context.named(), false);
	}
	public JWebButton(JWebContext context, String text, ButtonType type, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		buttonCode = new JWebButtonCode(getName());
		if(inflate){
			inflateView(text, type);
			return ;
		}
		initView(text, type);
	}
	private void initView(String text, ButtonType type){
		if(type == null){
			context.e(buttonCode.create(text));
			return ;
		}
		context.e(buttonCode.create(text,type.value()));
	}
	private void inflateView(String text, ButtonType type){
		if(type == null){
			context.e(buttonCode.inflate(text));
			return ;
		}
		context.e(buttonCode.inflate(text,type.value()));
	}
	public static JWebButton inflate(JWebContext context, String text, ButtonType type, String name){
		return new JWebButton(context, text, type, name, true);
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
