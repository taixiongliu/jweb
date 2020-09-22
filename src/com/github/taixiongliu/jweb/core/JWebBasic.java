package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebBasicCode;

public class JWebBasic extends JWeb{
	private JWebBasicCode basicCode;
	public JWebBasic(JWebContext context, Object object) {
		// TODO Auto-generated constructor stub
		super(context);
		initView(object);
	}
	private void initView(Object object){
		basicCode = new JWebBasicCode(context.named(), object);
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
