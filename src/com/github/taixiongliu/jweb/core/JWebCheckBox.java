package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebCheckBoxCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;

public class JWebCheckBox extends JWebEleJSView{
	private JWebCheckBoxCode checkBoxCode;
	
	public JWebCheckBox(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, context.named(), false);
	}
	public JWebCheckBox(JWebContext context, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		checkBoxCode = new JWebCheckBoxCode(getName());
		if(inflate){
			inflateView();
			return ;
		}
		initView();
	}
	private void initView(){
		context.e(checkBoxCode.create());
	}
	private void inflateView(){
		context.e(checkBoxCode.inflate());
	}
	public static JWebCheckBox inflate(JWebContext context, String name){
		return new JWebCheckBox(context, name, true);
	}
}
