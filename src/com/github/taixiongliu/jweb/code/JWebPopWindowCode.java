package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebPopWindowCode extends JWebEleJSCode{

	public JWebPopWindowCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(){
		return inflator("PopWindow");
	}
	public String inflate(int width, int height){
		return inflator("PopWindow", width, height);
	}
	public String create(){
		return constructor("PopWindow");
	}
	public String create(int width, int height){
		return constructor("PopWindow", width, height);
	}
	public String setTile(String title){
		return codeFormat("setTitle", title);
	}
	public String show(){
		return codeFormat("show");
	}
	public String addView(Expression ele){
		return codeFormat("addView", ele);
	}
	public String hide(){
		return codeFormat("hide");
	}
}
