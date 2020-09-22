package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.JWebIconLabelCode;
import com.github.taixiongliu.jweb.opts.IconLabelOpts;

public class JWebIconLabel extends JWebEleJSView{
	private JWebIconLabelCode menuListCode;
	public JWebIconLabel(JWebContext context, IconLabelOpts opts) {
		// TODO Auto-generated constructor stub
		this(context, opts.toJSObject());
	}
	public JWebIconLabel(JWebContext context, JSObject opts) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(opts);
	}
	private void initView(JSObject object){
		menuListCode = new JWebIconLabelCode(getName());
		context.e(menuListCode.create(object));
	}
}
