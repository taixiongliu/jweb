package com.github.taixiongliu.jweb.core.views;

import com.github.taixiongliu.jweb.code.views.JWebMaskingCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebEleJSView;

public class JWebMasking extends JWebEleJSView{
	private JWebMaskingCode maskingCode;
	public JWebMasking(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	private void initView(){
		maskingCode = new JWebMaskingCode(getName());
		context.e(maskingCode.create());
	}
	
	public void setContent(JWebEleJSView view){
		context.e(maskingCode.setContent(view.getExpression()));
	}
	
	public void showMasking(){
		context.e(maskingCode.showMasking());
	}
	
	public void hideMasking(){
		context.e(maskingCode.hideMasking());
	}
}
