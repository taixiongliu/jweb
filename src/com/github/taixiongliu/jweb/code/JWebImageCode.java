package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebImageCode extends JWebEleJSCode{
	public JWebImageCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String inflate(String url){
		return inflator("Img", url);
	}
	public String inflate(String url, String style){
		return inflator("Img", url, style);
	}
	public String create(String url){
		return constructor("Img", url);
	}
	public String create(String url, String style){
		return constructor("Img", url, style);
	}
	public String setUrl(String url){
		return name+".ele.src = \""+url+"\"";
	}
}
