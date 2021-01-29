package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebLayoutCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebLayout extends JWebEleJSView{
	private JWebLayoutCode layoutCode;
	public JWebLayout(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, null);
	}
	public JWebLayout(JWebContext context, String style) {
		// TODO Auto-generated constructor stub
		this(context, context.named(), style, false);
	}
	public JWebLayout(JWebContext context, String name, String style, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		if(inflate){
			inflateView(style);
			return ;
		}
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
	private void inflateView(String style){
		layoutCode = new JWebLayoutCode(getName());
		if(style == null){
			context.e(layoutCode.inflate());
			return ;
		}
		context.e(layoutCode.inflate(style));
	}
	
	public static JWebLayout inflate(JWebContext context, String name, String style){
		return new JWebLayout(context, name, style, true);
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
	public Expression getHeight(){
		return layoutCode.getHeight();
	}
	public void setHeight(String height){
		context.e(layoutCode.setHeight(height));
	}
	public void onClick(EventHandler handler){
		context.e(layoutCode.onClick(handler));
	}
	public JWebContext getContext(){
		return context;
	}
}
