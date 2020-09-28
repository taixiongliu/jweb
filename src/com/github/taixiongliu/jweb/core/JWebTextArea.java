package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.code.JWebTextAreaCode;

public class JWebTextArea extends JWebEleJSView{
	private JWebTextAreaCode textAreaCode;
	public JWebTextArea(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView();
	}
	private void initView(){
		textAreaCode = new JWebTextAreaCode(getName());
		context.e(textAreaCode.create());
	}
	
	public Expression getValue(){
		return textAreaCode.getValue();
	}
	public Sentence getValueSentence(){
		return textAreaCode.getValueSentence();
	}
}
