package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebImageCode;

public class JWebImage extends JWebEleJSView{
	private JWebImageCode imageCode;
	public JWebImage(JWebContext context, String url) {
		// TODO Auto-generated constructor stub
		this(context, url, null);
	}
	public JWebImage(JWebContext context, String url, String style) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(url, style);
	}
	private void initView(String url, String style){
		imageCode = new JWebImageCode(getName());
		if(url == null){
			url = "";
		}
		if(style == null){
			context.e(imageCode.create(url));
			return ;
		}
		context.e(imageCode.create(url, style));
	}
}
