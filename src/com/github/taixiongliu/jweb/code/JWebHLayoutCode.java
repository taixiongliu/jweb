package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.base.JWebEleJSCode;

public class JWebHLayoutCode extends JWebEleJSCode{
	public JWebHLayoutCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String inflate(){
		return inflator("HLayout");
	}
	public String inflate(String styleName){
		return inflator("HLayout", styleName);
	}
	public String create(){
		return constructor("HLayout");
	}
	public String create(String styleName){
		return constructor("HLayout", styleName);
	}
	public String addView(Expression ele, JSObject opts){
		if(opts == null){
			return codeFormat("add", ele);
		}
		return codeFormat("add", ele, opts);
	}
	public String setContainer(Expression ele){
		return codeFormat("setContainer", ele);
	}
	public String setContainerById(String id){
		return codeFormat("setContainerById", id);
	}
	public Expression getView(){
		return new Expression(codeFormat("getView"));
	}
	public String clear(){
		return codeFormat("clear");
	}
}
