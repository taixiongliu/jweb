package com.github.taixiongliu.jweb.core.views;

import com.github.taixiongliu.jweb.code.views.JWebBoardCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebEleJSView;

public class JWebBoard extends JWebEleJSView{
	private JWebBoardCode boardCode;
	public JWebBoard(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	private void initView(){
		boardCode = new JWebBoardCode(getName());
		context.e(boardCode.create());
	}
	
	public void add(JWebBoardView bview){
		context.e(boardCode.add(bview.getExpression()));
	}
}
