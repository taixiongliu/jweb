package com.github.taixiongliu.jweb.code.views;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebCode;

public class JWebMergeBoardCode extends JWebCode{

	public JWebMergeBoardCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Views.MergeBoard");
	}
	
	public String setLeft(Expression ele){
		return codeFormat("setLeft", ele);
	}
	
	public String setCenter(Expression ele){
		return codeFormat("setCenter", ele);
	}
	
	public String setRight(Expression ele){
		return codeFormat("setRight", ele);
	}
}
