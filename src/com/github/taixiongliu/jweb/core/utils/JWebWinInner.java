package com.github.taixiongliu.jweb.core.utils;

import com.github.taixiongliu.jweb.code.utils.JWebWinInnerCode;
import com.github.taixiongliu.jweb.core.JWebBasic;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebView;
import com.github.taixiongliu.jweb.handler.WindowResizeHandler;

public class JWebWinInner extends JWebView{
	private JWebWinInnerCode winInnerCode;
	public JWebWinInner(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context,context.named());
		initView();
	}
	private void initView(){
		winInnerCode = new JWebWinInnerCode(getName());
		context.e(winInnerCode.create());
	}
	
	public JWebBasic getHeight(){
		return new JWebBasic(context, winInnerCode.getHeight());
	}
	public JWebBasic getWidth(){
		return new JWebBasic(context, winInnerCode.getWidth());
	}
	public void addOnResizeHandler(WindowResizeHandler handler){
		context.e(winInnerCode.addResizeHandler(handler));
	}
}
