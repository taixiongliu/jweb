package com.github.taixiongliu.jweb.code;

public class JWebImageCode extends JWebEleJSCode{
	public JWebImageCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(String url){
		return constructor("Img", url);
	}
	public String create(String url, String style){
		return constructor("Img", url, style);
	}
}
