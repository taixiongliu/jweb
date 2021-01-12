package com.github.taixiongliu.jweb.code.views;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebCode;

public class JWebMaskingCode extends JWebCode{

	public JWebMaskingCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Views.Masking");
	}
	
	public String setContent(Expression ele){
		return codeFormat("setContent", ele);
	}
	public String showMasking(){
		return codeFormat("showMasking");
	}
	public String hideMasking(){
		return codeFormat("hideMasking");
	}
}
