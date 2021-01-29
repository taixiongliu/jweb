package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebListGridCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.handler.ListGridHandler;

public class JWebListGrid extends JWebEleJSView{
	private JWebListGridCode listGridCode;
	public JWebListGrid(JWebContext context, ListGridHandler listGridHandler) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView(listGridHandler);
	}
	private void initView(ListGridHandler listGridHandler){
		listGridCode = new JWebListGridCode(getName());
		context.e(listGridCode.create(listGridHandler.toJSObject()));
	}
	
	public void addRow(){
		
	}
	public Expression getSelect(){
		return listGridCode.getSelect();
	}
	
	public class Row{
		
	}
}
