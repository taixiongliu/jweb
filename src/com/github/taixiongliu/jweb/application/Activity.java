package com.github.taixiongliu.jweb.application;

import com.github.taixiongliu.jweb.ComponentBean;
import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebElement;
import com.github.taixiongliu.jweb.event.ActivityHandler;

public abstract class Activity implements ActivityHandler{
	public abstract void onCreateView(JWebContext context, JWebElement root);
	private JWebContext context;
	protected ComponentBean bean;
	protected Session session;
	public Activity(ComponentBean bean, Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
		this.bean = bean;
		context = new JWebContext() {
			
			@Override
			public String getNamePrefix() {
				// TODO Auto-generated method stub
				return "n";
			}
		};
		
		context.e("window.onload= ele_init;");
		context.e("function ele_init(){");
		context.e("Ele.load(function(){");
		
		JWebElement element = JWebElement.getElementById(context, "jweb_body");
		
		onCreateView(context, element);
		
		context.e("});}");
	}
	
	public String getViewContent() {
		// TODO Auto-generated method stub
		return context.getContent();
	}
}
