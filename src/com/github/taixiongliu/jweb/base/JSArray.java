package com.github.taixiongliu.jweb.base;

import java.util.ArrayList;
import java.util.List;

import com.github.taixiongliu.jweb.core.base.JWebView;

public class JSArray {
	private List<Object> properties;
	public JSArray() {
		// TODO Auto-generated constructor stub
		//一次执行的客户端编译代码无需考虑数据原子性
		properties = new ArrayList<Object>();
	}
	
	public void addProperty(Object value){
		properties.add(value);
	}
	public void clearProperty(){
		properties.clear();
	}
	public String toString(){
		if(properties == null || properties.isEmpty()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Object data : properties){
			//是否特定类型特定处理
			boolean spc = false;
			if(data instanceof String){
				sb.append("\"").append(data).append("\",");
				spc = true;
			}
			if(data instanceof JSObject){
				JSObject temp = (JSObject)data;
				sb.append(temp.toString()).append(",");
				spc = true;
			}
			if(data instanceof JSArray){
				JSArray temp = (JSArray)data;
				sb.append(temp.toString()).append(",");
				spc = true;
			}
			if(data instanceof JWebView){
				JWebView temp = (JWebView)data;
				sb.append(temp.getName()).append(",");
				spc = true;
			}
			//并非特定类型
			if(!spc){
				sb.append(data.toString()).append(",");
			}
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		return sb.toString();
	}
}
