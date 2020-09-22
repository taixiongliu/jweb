package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebLayoutCode;

public class JWebLayout extends JWebEleJSView{
	private JWebLayoutCode layoutCode;
	public JWebLayout(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, "");
	}
	public JWebLayout(JWebContext context, String style) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(style);
	}
	private void initView(String style){
		layoutCode = new JWebLayoutCode(getName());
		if(style == null){
			context.e(layoutCode.create());
			return ;
		}
		context.e(layoutCode.create(style));
	}
	
	public void setAlign(String align){
		context.e(layoutCode.setAlign(align));
	}
	
	public void addView(JWebEleJSView jWebView){
		context.e(layoutCode.addView(jWebView.getExpression()));
	}
	public void setContainer(JWebEleJSView jWebView){
		context.e(layoutCode.setContainer(jWebView.getExpression()));
	}
	public void setContainerById(String id){
		context.e(layoutCode.setContainerById(id));
	}
	public void removeView(JWebEleJSView jWebView){
		context.e(layoutCode.removeView(jWebView.getExpression()));
	}
	public void setHtml(String html){
		context.e(layoutCode.setHtml(html));
	}
	public void clear(){
		context.e(layoutCode.clear());
	}
	public JWebBasic getHeight(){
		return new JWebBasic(context, layoutCode.getHeight());
	}
	public void setHeight(String height){
		context.e(layoutCode.setHeight(height));
	}
	public JWebContext getContext(){
		return context;
	}
}
