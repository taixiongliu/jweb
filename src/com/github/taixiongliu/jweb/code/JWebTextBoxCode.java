package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.base.Sentence;

public class JWebTextBoxCode extends JWebEleJSCode{
	public JWebTextBoxCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(JSObject opts){
		return constructor("TextBox", opts);
	}
	public String create(){
		return constructor("TextBox");
	}
	
	public String hide(){
		return name+".ele.type = 'hidden';";
	}
	public Expression getValue(){
		return new Expression(name+".ele.value");
	}
	public Sentence getValueSentence(){
		return new Sentence(name+".ele.value;");
	}
	public String setType(String type){
		return name+".ele.type = '"+type+"';";
	}
}
