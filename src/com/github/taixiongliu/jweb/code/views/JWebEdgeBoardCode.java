package com.github.taixiongliu.jweb.code.views;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebCode;

public class JWebEdgeBoardCode extends JWebCode{

	public JWebEdgeBoardCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Views.EdgeBoard");
	}
	
	public String setLeft(Expression ele){
		return codeFormat("setLeft", ele);
	}
	
	public String setRight(Expression ele){
		return codeFormat("setRight", ele);
	}
}
