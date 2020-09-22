package com.github.taixiongliu.jweb.core;

import java.util.ArrayList;
import java.util.List;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.code.JWebAjaxCode;
import com.github.taixiongliu.jweb.handler.AjaxCallbackHandler;

public class JWebAjax extends JWebView{
	private JWebAjaxCode ajaxCode;
	private List<JSBase> parameters;
	public JWebAjax(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	private void initView(){
		ajaxCode = new JWebAjaxCode(getName());
		context.e(ajaxCode.create());
		parameters = new ArrayList<JSBase>();
	}
	
	public void setMethod(String method){
		context.e(ajaxCode.setMethod(method));
	}
	public void setSynchronization(boolean syn){
		context.e(ajaxCode.setSynchronization(syn));
	}
	public void addParameter(JSBase base){
		parameters.add(base);
	}
	public void request(String url, AjaxCallbackHandler handler){
		if(!parameters.isEmpty()){
			String parameter = "";
			int i = 0;
			for(JSBase base : parameters){
				if(i != 0){
					parameter += "+\"&";
				}else{
					parameter += "\"";
				}
				parameter += (base.getName()+"=\"+"+base.formatValue());
				i ++;
			}
			context.e(ajaxCode.setParameter(new Expression(parameter)));
		}
		context.e(ajaxCode.request(url,handler));
	}
}
