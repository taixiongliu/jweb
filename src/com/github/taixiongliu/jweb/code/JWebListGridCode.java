package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebListGridCode extends JWebEleJSCode{

	public JWebListGridCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String inflate(JSObject opts){
		return inflator("ListGrid", opts);
	}
	public String create(JSObject opts){
		return constructor("ListGrid", opts);
	}
	public String addRow(JSObject row){
		return codeFormat("addRow", row);
	}
	public Expression getSelect(){
		return ExpressionFormat("getSelect");
	}
}
