package com.github.taixiongliu.jweb.code.utils;

import com.github.taixiongliu.jweb.code.base.JWebCode;
import com.github.taixiongliu.jweb.handler.TimerHandler;

public class JWebTimerCode extends JWebCode{

	public JWebTimerCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("Utils.Timer");
	}
	public String create(TimerHandler handler){
		return constructor("Utils.Timer", handler);
	}
	public String create(TimerHandler handler, int interval){
		return constructor("Utils.Timer", handler, interval);
	}
	
	public String execute(){
		return codeFormat("execute");
	}
}
