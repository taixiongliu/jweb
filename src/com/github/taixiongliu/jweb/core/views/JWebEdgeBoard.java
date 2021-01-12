package com.github.taixiongliu.jweb.core.views;

import com.github.taixiongliu.jweb.code.views.JWebEdgeBoardCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebEleJSView;

public class JWebEdgeBoard extends JWebBoardView{
	private JWebEdgeBoardCode edgeBoardCode;
	public JWebEdgeBoard(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context);
		initView();
	}
	private void initView(){
		edgeBoardCode = new JWebEdgeBoardCode(getName());
		context.e(edgeBoardCode.create());
	}
	
	public void setLeft(JWebEleJSView view){
		context.e(edgeBoardCode.setLeft(view.getExpression()));
	}
	public void setRight(JWebEleJSView view){
		context.e(edgeBoardCode.setRight(view.getExpression()));
	}
}
