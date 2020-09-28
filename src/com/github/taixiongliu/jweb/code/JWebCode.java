package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;

public class JWebCode{
	protected String name;
	public JWebCode(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	protected String constructor(String model){
		StringBuilder sb = new StringBuilder("var ");
		sb.append(name).append(" = new Ele.").append(model).append("();");
		return sb.toString();
	}
	protected String constructor(String model, Object... parameters){
		if(parameters == null){
			return constructor(model);
		}
		StringBuilder sb = new StringBuilder("var ");
		sb.append(name).append(" = new Ele.").append(model).append("(");
		int last = parameters.length - 1;
		for(int i = 0; i < parameters.length; i++){
			sb.append(JSBase.formatValue(parameters[i]));
			if(i != last){
				sb.append(",");
			}
		}
		sb.append(");");
		return sb.toString();
	}
	
	protected String codeFormat(String method){
		StringBuilder sb = new StringBuilder(name);
		sb.append(".").append(method).append("();");
		return sb.toString();
	}
	protected String codeFormat(String method, Object... values){
		if(values == null){
			return codeFormat(method);
		}
		
		StringBuilder sb = new StringBuilder(name);
		sb.append(".").append(method).append("(");
		int last = values.length - 1;
		for(int i = 0; i < values.length; i++){
			sb.append(JSBase.formatValue(values[i]));
			if(i != last){
				sb.append(",");
			}
		}
		sb.append(");");
		return sb.toString();
	}
	protected Expression ExpressionFormat(String method, Object... values){
		if(values == null){
			return ExpressionFormat(method);
		}
		
		StringBuilder sb = new StringBuilder(name);
		sb.append(".").append(method).append("(");
		int last = values.length - 1;
		for(int i = 0; i < values.length; i++){
			sb.append(JSBase.formatValue(values[i]));
			if(i != last){
				sb.append(",");
			}
		}
		sb.append(")");
		return new Expression(sb.toString());
	}
}
