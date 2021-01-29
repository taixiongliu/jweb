package com.github.taixiongliu.jweb.base;

import com.github.taixiongliu.jweb.core.base.JWebBase;
import com.github.taixiongliu.jweb.core.base.JWebView;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JSBase {
	private String name;
	private Object value;
	public JSBase(String name, Object value) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	public String getCode() {
		if(name == null || name.trim().equals("")){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("var ").append(getValueCode());
		return sb.toString();
	}

	public String getValueCode() {
		if(name == null || name.trim().equals("")){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		if(value == null){
			sb.append(";");
			return sb.toString();
		}
		sb.append(" = ");
		sb.append(formatValue()).append(";");
		return sb.toString();
	}
	public String formatValue(){
		return formatValue(value);
	}
	
	public static String formatValue(Object value){
		if(value == null){
			return "null";
		}
		if(value instanceof String){
			return "\""+value+"\"";
		}
		if(value instanceof Expression){
			Expression temp = (Expression)value;
			return temp.getExp();
		}
		if(value instanceof JSObject){
			JSObject temp = (JSObject)value;
			return temp.toString();
		}
		if(value instanceof JSArray){
			JSArray temp = (JSArray)value;
			return temp.toString();
		}
		if(value instanceof EventHandler){
			EventHandler temp = (EventHandler)value;
			return temp.toCode();
		}
		if(value instanceof JWebView){
			JWebView temp = (JWebView)value;
			return temp.getName();
		}
		if(value instanceof JWebBase){
			JWebBase temp = (JWebBase)value;
			return temp.getName();
		}
		return value.toString();
	}
}
