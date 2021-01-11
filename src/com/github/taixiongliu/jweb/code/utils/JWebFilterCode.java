package com.github.taixiongliu.jweb.code.utils;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.code.JWebCode;

public class JWebFilterCode extends JWebCode{

	public JWebFilterCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Utils.Filter");
	}
	
	public String isStoreId(Expression text){
		return codeFormat("isStoreId", text);
	}
	public String isAccount(Expression text){
		return codeFormat("isAccount", text);
	}
	public String isNumber(Expression text){
		return codeFormat("isNumber", text);
	}
	public String isPhoneNumber(Expression text){
		return codeFormat("isPhoneNumber", text);
	}
	public String isCount(Expression text){
		return codeFormat("isCount", text);
	}
	public String isSqlKey(Expression text){
		return codeFormat("isSqlKey", text);
	}
}
