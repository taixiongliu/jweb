package com.github.taixiongliu.jweb.core.views;

import com.github.taixiongliu.jweb.code.views.JWebHLineBoardCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;

public class JWebHLineBoard extends JWebBoardView{
	private JWebHLineBoardCode hLineBoardCode;
	public JWebHLineBoard(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context);
		initView();
	}
	private void initView(){
		hLineBoardCode = new JWebHLineBoardCode(getName());
		context.e(hLineBoardCode.create());
	}
	
	public void add(JWebEleJSView view, int percent){
		context.e(hLineBoardCode.add(view.getExpression(), percent));
	}
}
