package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.event.EventHandler;

public class JWebWinInnerCode extends JWebCode{

	public JWebWinInnerCode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public String create(){
		return constructor("WinInner");
	}
	
	public Expression getWidth(){
		return new Expression(name+".getWidth()"); 
	}
	public Expression getHeight(){
		return new Expression(name+".getHeight()"); 
	}
	public String addResizeHandler(EventHandler handler){
		return codeFormat("addResizeHandler", handler);
	}
}
