package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.code.JWebCButtonCode;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class JWebCButton extends JWebEleJSView{
	private JWebCButtonCode cbuttonCode;
	public JWebCButton(JWebContext context, String sstyle, String estyle) {
		// TODO Auto-generated constructor stub
		this(context, context.named(), sstyle, estyle, false);
		
	}
	public JWebCButton(JWebContext context, String sstyle, String estyle, String name, boolean inflate) {
		// TODO Auto-generated constructor stub
		super(context, name);
		cbuttonCode = new JWebCButtonCode(getName());
		
		if(inflate){
			inflateView(sstyle, estyle);
			return ;
		}
		initView(sstyle, estyle);
	}
	private void initView(String sstyle, String estyle){
		context.e(cbuttonCode.create(sstyle,estyle));
	}
	private void inflateView(String sstyle, String estyle){
		context.e(cbuttonCode.inflate(sstyle,estyle));
	}
	public static JWebCButton inflate(JWebContext context, String sstyle, String estyle, String name){
		return new JWebCButton(context, sstyle, estyle, name, true);
	}
	
	public void removeClickHandler(){
		context.e(cbuttonCode.removeClickHandler());
	}
	public void setClickHandler(ItemClickHandler handler){
		context.e(cbuttonCode.setClickHandler(handler));
	}
}
