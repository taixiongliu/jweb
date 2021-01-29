package com.github.taixiongliu.jweb.base;

import com.github.taixiongliu.jweb.core.JWebContext;

public abstract class JSFunction {
	private String name;
	private JWebContext context;
	public abstract void onFunction(JWebContext context);
	public JSFunction(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		context = new JWebContext() {
			
			@Override
			public String getNamePrefix() {
				// TODO Auto-generated method stub
				return name;
			}
		};
		
		onFunction(context);
	}
	
	public String toCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("function ").append(name).append("(){").append(context.getContent()).append("};");
		return sb.toString();
	}
}
