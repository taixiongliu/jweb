package com.github.taixiongliu.jweb.core.base;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebBaseCode;
import com.github.taixiongliu.jweb.core.JWebContext;

public class JWebBase extends JWeb{
	private JWebBaseCode basicCode;
	public JWebBase(JWebContext context, Object object) {
		// TODO Auto-generated constructor stub
		super(context);
		initView(object);
	}
	private void initView(Object object){
		basicCode = new JWebBaseCode(context.named(), object);
		context.e(basicCode.create());
	}
	public String getName(){
		return basicCode.getName();
	}
	public Expression getProperty(String property){
		return new Expression(getName()+"."+property);
	}
	public Object getValue() {
		return basicCode.getValue();
	}
}
