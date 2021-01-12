package com.github.taixiongliu.jweb.code.views;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebCode;

public class JWebEmptyBoardCode extends JWebCode{

	public JWebEmptyBoardCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Views.EmptyBoard");
	}
	
	public String addBoard(Expression ele){
		return codeFormat("addBoard", ele);
	}
}
