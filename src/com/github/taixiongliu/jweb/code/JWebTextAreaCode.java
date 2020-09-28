package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.Sentence;

public class JWebTextAreaCode extends JWebEleJSCode{
	public JWebTextAreaCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(){
		return constructor("TextArea");
	}
	
	public Expression getValue(){
		return new Expression(name+".ele.value");
	}
	public Sentence getValueSentence(){
		return new Sentence(name+".ele.value;");
	}
}
