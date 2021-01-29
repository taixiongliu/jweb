package com.github.taixiongliu.jweb.code.views;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.base.JWebCode;

public class JWebHLineBoardCode extends JWebCode{

	public JWebHLineBoardCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Views.HLineBoard");
	}
	
	public String add(Expression ele, int percent){
		return codeFormat("add", ele, percent);
	}
}
