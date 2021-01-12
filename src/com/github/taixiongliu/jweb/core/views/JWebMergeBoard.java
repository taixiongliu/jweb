package com.github.taixiongliu.jweb.core.views;

import com.github.taixiongliu.jweb.code.views.JWebMergeBoardCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebEleJSView;

public class JWebMergeBoard extends JWebBoardView{
	private JWebMergeBoardCode mergeBoardCode;
	public JWebMergeBoard(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context);
		initView();
	}
	private void initView(){
		mergeBoardCode = new JWebMergeBoardCode(getName());
		context.e(mergeBoardCode.create());
	}
	
	public void setLeft(JWebEleJSView view){
		context.e(mergeBoardCode.setLeft(view.getExpression()));
	}
	public void setCenter(JWebEleJSView view){
		context.e(mergeBoardCode.setCenter(view.getExpression()));
	}
	public void setRight(JWebEleJSView view){
		context.e(mergeBoardCode.setRight(view.getExpression()));
	}
}
