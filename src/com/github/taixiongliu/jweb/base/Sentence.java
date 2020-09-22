package com.github.taixiongliu.jweb.base;

public class Sentence{
	private String code;
	public Sentence(String code) {
		// TODO Auto-generated constructor stub
		this.code = code;
	}
	public Sentence(Expression exp) {
		// TODO Auto-generated constructor stub
		this.code = exp.getExp()+";";
	}

	public String toCode(){
		return code;
	}
}
