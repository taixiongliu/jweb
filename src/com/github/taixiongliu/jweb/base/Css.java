package com.github.taixiongliu.jweb.base;

import java.util.HashMap;
import java.util.Map;

import com.github.taixiongliu.jweb.enums.CssType;

public class Css {
	private String name;
	private CssType cssType;
	private Map<String, String> map;
	public Css(String name) {
		// TODO Auto-generated constructor stub
		this(CssType.CLASS, name);
	}
	public Css(CssType type, String name){
		map = new HashMap<String, String>();
		this.cssType = type;
		this.name = name;
	}
	
	public void put(String key, String value){
		map.put(key, value);
	}
	
	public void putAll(Map<String, String> map){
		map.putAll(map);
	}
	public boolean remove(String key){
		String value = map.remove(key);
		return value != null;
	}
	public void clear(){
		map.clear();
	}
	public int size(){
		return map.size();
	}
	public String toCssString(){
		StringBuilder sb = new StringBuilder();
		sb.append(cssType.toString()).append(name).append("{");
		for(String key : map.keySet()){
			sb.append(key).append(":").append(map.get(key)).append(";");
		}
		sb.append("}");
		return sb.toString();
	}
}
