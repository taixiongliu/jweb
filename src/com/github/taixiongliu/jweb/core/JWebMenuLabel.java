package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebMenuLabelCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.opts.MenuLabelOpts;

public class JWebMenuLabel extends JWebEleJSView{
	private JWebMenuLabelCode menuLabelCode;
	public JWebMenuLabel(JWebContext context, MenuLabelOpts opts) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(opts);
	}
	private void initView(MenuLabelOpts opts){
		menuLabelCode = new JWebMenuLabelCode(getName());
		context.e(menuLabelCode.create(opts.toJSObject()));
	}
	public void setText(String text){
		context.e(menuLabelCode.setText(text));
	}
	
	public void showChildren(){
		context.e(menuLabelCode.showChildren());
	}
	public void hideChildren(){
		context.e(menuLabelCode.hideChildren());
	}
	public void addOpts(MenuLabelOpts datasources){
		context.e(menuLabelCode.addChild(datasources.toJSObject()));
	}
}
