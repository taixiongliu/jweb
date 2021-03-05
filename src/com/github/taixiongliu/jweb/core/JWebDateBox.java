package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.code.JWebDateBoxCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebDateBox extends JWebEleJSView{
	private JWebDateBoxCode dateBoxCode;
	
	public JWebDateBox(JWebContext context) {
		// TODO Auto-generated constructor stub
		this(context, context.named(), false);
	}
	public JWebDateBox(JWebContext context, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		dateBoxCode = new JWebDateBoxCode(getName());
		if(inflate){
			inflateView();
			return ;
		}
		initView();
	}
	private void initView(){
		context.e(dateBoxCode.create());
	}
	private void inflateView(){
		context.e(dateBoxCode.inflate());
	}
	public static JWebDateBox inflate(JWebContext context, String name){
		return new JWebDateBox(context, name, true);
	}
	
	public void setSelectUpdateHandler(EventHandler handler){
		context.e(dateBoxCode.setSelectUpdateHandler(handler));
	}
	public void removeSelectUpdateHandler(){
		context.e(dateBoxCode.removeSelectUpdateHandler());
	}
	public void setPageUpdateHandler(EventHandler handler){
		context.e(dateBoxCode.setPageUpdateHandler(handler));
	}
	public void removePageUpdateHandler(){
		context.e(dateBoxCode.removePageUpdateHandler());
	}
	
	public Sentence getSelectDateString(){
		return new Sentence(dateBoxCode.getSelectDateString());
	}
	public void previousMonth(){
		context.e(dateBoxCode.previousMonth());
	}
	public void previousYear(){
		context.e(dateBoxCode.previousYear());
	}
	public void nextMonth(){
		context.e(dateBoxCode.nextMonth());
	}
	public void nextYear(){
		context.e(dateBoxCode.nextYear());
	}
	public void hide(){
		context.e(dateBoxCode.hide());
	}
	public void show(String left, String top){
		context.e(dateBoxCode.show(left, top));
	}
	public void showBelowLeft(JWebEleJSView view){
		context.e(dateBoxCode.showBelowLeft(view.getEle()));
	}
}
