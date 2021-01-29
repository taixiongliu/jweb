package com.github.taixiongliu.jweb.core.utils;

import com.github.taixiongliu.jweb.code.utils.JWebTimerCode;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.base.JWebView;
import com.github.taixiongliu.jweb.handler.TimerHandler;

public class JWebTimer extends JWebView{
	private JWebTimerCode timerCode;
	public JWebTimer(JWebContext context, TimerHandler handler) {
		// TODO Auto-generated constructor stub
		this(context, handler, null);
	}
	public JWebTimer(JWebContext context, TimerHandler handler, Integer interval) {
		// TODO Auto-generated constructor stub
		super(context, context.named());
		initView(handler, interval);
	}
	private void initView(TimerHandler handler, Integer interval){
		timerCode = new JWebTimerCode(getName());
		if(handler == null){
			context.e(timerCode.create());
			return ;
		}
		if(interval == null){
			context.e(timerCode.create(handler));
			return ;
		}
		context.e(timerCode.create(handler, interval.intValue()));
	}
	
	public void execute(){
		context.e(timerCode.execute());
	}
}
