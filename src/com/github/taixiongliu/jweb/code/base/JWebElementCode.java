package com.github.taixiongliu.jweb.code.base;

import com.github.taixiongliu.jweb.base.Expression;

public class JWebElementCode extends JWebCode {
	public JWebElementCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	public String createById(String id){
		StringBuilder sb = new StringBuilder("var ");
		sb.append(name).append(" = document.getElementById(\"").append(id).append("\");");
		return sb.toString();
	}
	
	public String appendChild(Expression ele){
		StringBuilder sb = new StringBuilder(name);
		sb.append(".appendChild(").append(ele.getExp()).append(");");
		return sb.toString();
	}
}
