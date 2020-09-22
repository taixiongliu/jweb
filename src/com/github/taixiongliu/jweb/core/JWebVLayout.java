package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.JWebVLayoutCode;
import com.github.taixiongliu.jweb.opts.HLayoutOpts;

public class JWebVLayout extends JWebEleJSView{
	private JWebVLayoutCode vLayoutCode;
	public JWebVLayout(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, "");
	}
	public JWebVLayout(JWebContext context, String styleName) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(styleName);
	}
	private void initView(String styleName){
		vLayoutCode = new JWebVLayoutCode(getName());
		if(styleName == null){
			context.e(vLayoutCode.create());
			return ;
		}
		context.e(vLayoutCode.create(styleName));
	}
	
	public void addView(JWebEleJSView jWebView){
		this.addView(jWebView, null);
	}
	public void addViewOpts(JWebEleJSView jWebView, HLayoutOpts opts){
		if(opts == null){
			context.e(vLayoutCode.addView(jWebView.getExpression(), null));
		}
		context.e(vLayoutCode.addView(jWebView.getExpression(), opts.toJSObject()));
	}
	public void addView(JWebEleJSView jWebView, JSObject object){
		context.e(vLayoutCode.addView(jWebView.getExpression(), object));
	}
	public void setContainer(JWebEleJSView jWebView){
		context.e(vLayoutCode.setContainer(jWebView.getExpression()));
	}
	public void setContainerById(String id){
		context.e(vLayoutCode.setContainerById(id));
	}
	public void clear(){
		context.e(vLayoutCode.clear());
	}
	public JWebBasic getView(){
		return new JWebBasic(context, vLayoutCode.getView());
	}
	public JWebContext getContext(){
		return context;
	}
}
