package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.code.JWebMenuListCode;
import com.github.taixiongliu.jweb.handler.MenuListItemHandler;
import com.github.taixiongliu.jweb.opts.MenuListOpts;

public class JWebMenuList extends JWebEleJSView{
	private JWebMenuListCode menuListCode;
	public JWebMenuList(JWebContext context, MenuListItemHandler handler) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(handler);
	}
	private void initView(MenuListItemHandler handler){
		menuListCode = new JWebMenuListCode(getName());
		
		JSObject callback = new JSObject();
		callback.putProperty("onItemClick", handler);
		context.e(menuListCode.create(callback));
	}
	public void setTitle(String title){
		context.e(menuListCode.setTile(title));
	}
	
	public void add(JSObject object){
		context.e(menuListCode.add(object));
	}
	public void addOpts(MenuListOpts opts){
		context.e(menuListCode.add(opts.toJSObject()));
	}
	
	public void setHeight(String height){
		context.e(menuListCode.setHeight(height));
	}
	
	public void setHeightSub(JWebBasic basic, int subNumber){
		String expression = "("+basic.getName()+" - "+subNumber+")+'px'";
		context.e(menuListCode.setHeight(expression));
	}
	public void setHeightSub(Expression exp, int subNumber){
		String expression = "("+exp.getExp()+" - "+subNumber+")+'px'";
		context.e(menuListCode.setHeight(expression));
	}
}
