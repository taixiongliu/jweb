package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.code.JWebICheckBoxCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebICheckBox extends JWebEleJSView{
	private JWebICheckBoxCode iCheckBoxCode;
	public JWebICheckBox(JWebContext context) {
		super(context, context.named());
		// TODO Auto-generated constructor stub
		initView();
	}
	private void initView(){
		iCheckBoxCode = new JWebICheckBoxCode(getName());
		context.e(iCheckBoxCode.create());
	}
	
	public void click(){
		context.e(iCheckBoxCode.click());
	}
	public void checked(){
		context.e(iCheckBoxCode.checked());
	}
	public void unChecked(){
		context.e(iCheckBoxCode.unChecked());
	}
	public Sentence isChecked(){
		return new Sentence(iCheckBoxCode.isChecked());
	}
	public void addClickEvent(ItemClickHandler handler){
		context.e(iCheckBoxCode.addClickEvent(handler));
	}
}
