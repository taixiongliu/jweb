package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.JWebHLayoutCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.opts.HLayoutOpts;

public class JWebHLayout extends JWebEleJSView{
	private JWebHLayoutCode hLayoutCode;
	public JWebHLayout(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, null);
	}
	public JWebHLayout(JWebContext context, String styleName) {
		// TODO Auto-generated constructor stub
		this(context, styleName, context.named(), false);
	}
	public JWebHLayout(JWebContext context, String styleName, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		hLayoutCode = new JWebHLayoutCode(getName());
		if(inflate){
			inflateView(styleName);
			return ;
		}
		initView(styleName);
	}
	private void initView(String styleName){
		if(styleName == null){
			context.e(hLayoutCode.create());
			return ;
		}
		context.e(hLayoutCode.create(styleName));
	}
	private void inflateView(String styleName){
		if(styleName == null){
			context.e(hLayoutCode.inflate());
			return ;
		}
		context.e(hLayoutCode.inflate(styleName));
	}
	public static JWebHLayout inflate(JWebContext context, String styleName, String name){
		return new JWebHLayout(context, styleName, name, true);
	}
	
	public void addView(JWebEleJSView jWebView){
		this.addView(jWebView, null);
	}
	
	public void addViewOpts(JWebEleJSView jWebView, HLayoutOpts opts){
		if(opts == null){
			context.e(hLayoutCode.addView(jWebView.getExpression(), null));
		}
		context.e(hLayoutCode.addView(jWebView.getExpression(), opts.toJSObject()));
	}
	public void addView(JWebEleJSView jWebView, JSObject jsObject){
		context.e(hLayoutCode.addView(jWebView.getExpression(), jsObject));
	}
	public void setContainer(JWebEleJSView jWebView){
		context.e(hLayoutCode.setContainer(jWebView.getExpression()));
	}
	public void setContainerById(String id){
		context.e(hLayoutCode.setContainerById(id));
	}
	public void clear(){
		context.e(hLayoutCode.clear());
	}
	public Expression getView(){
		return hLayoutCode.getView();
	}
	public JWebContext getContext(){
		return context;
	}
}
