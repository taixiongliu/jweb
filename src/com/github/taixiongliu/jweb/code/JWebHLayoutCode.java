package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.base.Sentence;

public class JWebHLayoutCode extends JWebEleJSCode{
	public JWebHLayoutCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
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
	public Sentence getView(){
		return new Sentence(codeFormat("getView"));
	}
	public String clear(){
		return codeFormat("clear");
	}
}
