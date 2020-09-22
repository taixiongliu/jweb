package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebLabelCode;

public class JWebLabel extends JWebEleJSView{
	private JWebLabelCode labelCode;
	private String text;
	public JWebLabel(JWebContext context, String text) {
		// TODO Auto-generated constructor stub
		this(context, text, null);
	}
	public JWebLabel(JWebContext context, String text, String style) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(text, style);
	}
	private void initView(String text, String style){
		this.text = text;
		labelCode = new JWebLabelCode(getName());
		if(text == null){
			text = "";
		}
		if(style == null){
			context.e(labelCode.create(text));
			return ;
		}
		context.e(labelCode.create(text, style));
	}
	
	public String getText(){
		return text;
	}
}
