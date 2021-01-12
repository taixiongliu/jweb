package com.github.taixiongliu.jweb.core.views;

import com.github.taixiongliu.jweb.code.views.JWebEmptyBoardCode;
import com.github.taixiongliu.jweb.core.JWebContext;

public class JWebEmptyBoard extends JWebBoardView{
	private JWebEmptyBoardCode emptyBoardCode;
	public JWebEmptyBoard(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context);
		initView();
	}
	private void initView(){
		emptyBoardCode = new JWebEmptyBoardCode(getName());
		context.e(emptyBoardCode.create());
	}
	
	public void addBoard(JWebBoardView bview){
		context.e(emptyBoardCode.addBoard(bview.getExpression()));
	}
}
