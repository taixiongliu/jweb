package com.github.taixiongliu.jweb.core;

import java.util.HashMap;
import java.util.Map;

import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.event.IFunction;

public class JWebFunction{
	private String parameter;
	private Map<String, JSBase> properties;
	private JWebContext context;
	private IFunction iFunction;
	public JWebFunction(IFunction iFunction, String parameter) {
		// TODO Auto-generated constructor stub
		this(iFunction, parameter, "fn");
	}
	public JWebFunction(IFunction iFunction, String parameter, String prefix) {
		// TODO Auto-generated constructor stub
		this.iFunction = iFunction;
		this.parameter = parameter;
		properties = new HashMap<String, JSBase>();
		context = new JWebContext(){
			@Override
			public String getNamePrefix() {
				// TODO Auto-generated method stub
				return prefix;
			}
		};
	}
	
	public void load(){
		iFunction.onCallBack(context);
	}
	
	public void addProperty(JSBase base){
		//context replace.
		if(base == null){
			return ;
		}
		Object value = base.getValue();
		if(base.getName() == null || value == null){
			return ;
		}
		
		if(value instanceof JWeb){
			((JWeb)value).setContext(context);
		}
		properties.put(base.getName(), base);
	}
	public JSBase getProperty(String name){
		return properties.get(name);
	}
	public String toFunctionString(){
		StringBuilder code = new StringBuilder();
		code.append("function").append("("+parameter+"){");
		setProperties(code);
		code.append(context.getContent()).append("}");
		return code.toString();
	}
	
	private void setProperties(StringBuilder code){
		if(properties.isEmpty()){
			return ;
		}
		for(String key : properties.keySet()){
			JSBase basic = properties.get(key);
			code.append("this.").append(basic.getName()).append("=").append(basic.formatValue()).append(";");
		}
	}
	public String named() {
		// TODO Auto-generated method stub
		return context.named();
	}
}
