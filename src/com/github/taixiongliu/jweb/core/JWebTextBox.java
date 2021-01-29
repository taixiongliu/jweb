package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.code.JWebTextBoxCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.opts.TextBoxOpts;

public class JWebTextBox extends JWebEleJSView{
	private JWebTextBoxCode textBoxCode;
	public JWebTextBox(JWebContext context) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(null);
	}
	public JWebTextBox(JWebContext context, TextBoxOpts opts) {
		// TODO Auto-generated constructor stub
		this(context, opts.toJSObject());
	}
	public JWebTextBox(JWebContext context, JSObject opts) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(opts);
	}
	private void initView(JSObject opts){
		textBoxCode = new JWebTextBoxCode(getName());
		if(opts == null){
			context.e(textBoxCode.create());
			return ;
		}
		context.e(textBoxCode.create(opts));
	}
	
	public Expression getValue(){
		return textBoxCode.getValue();
	}
	public Sentence getValueSentence(){
		return textBoxCode.getValueSentence();
	}
	public void setType(String type){
		context.e(textBoxCode.setType(type));
	}
}
