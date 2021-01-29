package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebCheckBoxCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;

public class JWebCheckBox extends JWebEleJSView{
	private JWebCheckBoxCode checkBoxCode;
	
	public JWebCheckBox(JWebContext context) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView();
	}
	private void initView(){
		checkBoxCode = new JWebCheckBoxCode(getName());
		context.e(checkBoxCode.create());
	}
}
