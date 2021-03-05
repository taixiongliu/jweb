package com.github.taixiongliu.jweb.handler;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.core.JWebContext;

public abstract class AjaxCallbackHandler extends BaseHandler{
	public AjaxCallbackHandler(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, "ajn");
	}
	public AjaxCallbackHandler(JWebContext context, String prefix) {
		// TODO Auto-generated constructor stub
		super(context,"res",prefix);
	}
	
	public Expression toJson(JWebContext context){
		String name = function.named();
		context.e("var "+name+"="+context.jsonParse(new Expression("res"))+";");
		return new Expression(name);
	}
	
	public void defaultResult(){
		
	}
	
	public void whenCodeEquals(JWebContext context, Expression json,String codeName, int code, Sentence sentence){
		//"if("+json.getExp()+"."+codeName+"=="+code+"){"+expression.getExp()+";return;}"
		StringBuilder sb = new StringBuilder("if(");
		sb.append(json.getExp()).append(".").append(codeName).append("==").append(code).append("){")
		.append(sentence.toCode()).append("return;}");
		context.e(sb.toString());
	}
	
	public void alertMsg(JWebContext context, Expression json, String field){
		context.alert(new Expression(json.getExp()+"."+field));
	}
}
