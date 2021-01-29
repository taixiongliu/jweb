package com.github.taixiongliu.jweb.core.utils;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.code.utils.JWebFilterCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.base.JWebView;

public class JWebFilter extends JWebView{
	private JWebFilterCode filterCode;
	public JWebFilter(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	private void initView(){
		filterCode = new JWebFilterCode(getName());
		context.e(filterCode.create());
	}
	
	public Sentence isStoreId(Expression text){
		return new Sentence(filterCode.isStoreId(text));
	}
	public Sentence isAccount(Expression text){
		return new Sentence(filterCode.isAccount(text));
	}
	public Sentence isNumber(Expression text){
		return new Sentence(filterCode.isNumber(text));
	}
	public Sentence isPhoneNumber(Expression text){
		return new Sentence(filterCode.isPhoneNumber(text));
	}
	public Sentence isCount(Expression text){
		return new Sentence(filterCode.isCount(text));
	}
	public Sentence isSqlKey(Expression text){
		return new Sentence(filterCode.isSqlKey(text));
	}
}
