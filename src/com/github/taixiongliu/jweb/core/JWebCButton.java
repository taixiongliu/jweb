package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebCButtonCode;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebCButton extends JWebEleJSView{
	private JWebCButtonCode cbuttonCode;
	public JWebCButton(JWebContext context, String sstyle, String estyle) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView(sstyle, estyle);
	}
	private void initView(String sstyle, String estyle){
		cbuttonCode = new JWebCButtonCode(getName());
		context.e(cbuttonCode.create(sstyle,estyle));
	}
	public void removeClickHandler(){
		context.e(cbuttonCode.removeClickHandler());
	}
	public void setClickHandler(ItemClickHandler handler){
		context.e(cbuttonCode.setClickHandler(handler));
	}
}
