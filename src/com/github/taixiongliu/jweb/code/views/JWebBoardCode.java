package com.github.taixiongliu.jweb.code.views;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebCode;

public class JWebBoardCode extends JWebCode{

	public JWebBoardCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Views.Board");
	}
	
	public String add(Expression ele){
		return codeFormat("add", ele);
	}
}
