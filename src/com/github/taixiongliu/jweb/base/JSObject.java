package com.github.taixiongliu.jweb.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSObject {
	private Map<String, Object> properties;
	public JSObject() {
		// TODO Auto-generated constructor stub
		//一次执行的客户端编译代码无需考虑数据原子性
		properties = new HashMap<String, Object>();
	}
	
	public void putProperty(String name, Object value){
		properties.put(name, value);
	}
	public void removeProperty(String name){
		properties.remove(name);
	}
	public void clearProperty(){
		properties.clear();
	}
	public Object get(String key){
		return properties.get(key);
	}
	public Set<String> keySet(){
		return properties.keySet();
	}
	
	public String keyString(){
		if(properties == null || properties.isEmpty()){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(String property : properties.keySet()){
			sb.append(property).append(",");
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	public String toString(){
		if(properties == null || properties.isEmpty()){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(String property : properties.keySet()){
			sb.append(property).append(":");
			Object data = properties.get(property);
			sb.append(JSBase.formatValue(data)).append(",");
		}
		if(sb.length() > 1){
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("}");
		return sb.toString();
	}
}
