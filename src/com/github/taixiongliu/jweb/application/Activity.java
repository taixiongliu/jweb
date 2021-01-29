package com.github.taixiongliu.jweb.application;

import java.util.ArrayList;
import java.util.List;

import com.github.taixiongliu.jweb.ComponentBean;
import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.base.JSFunction;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.base.JWebElement;
import com.github.taixiongliu.jweb.event.ActivityHandler;

public abstract class Activity implements ActivityHandler{
	private static List<String> loads;
	private static List<JSBase> definitions;
	private static List<JSFunction> functions;
	public static void importJS(String js){
		if(loads == null){
			loads = new ArrayList<String>();
		}
		loads.add(js);
	}
	public static void definition(JSBase jsBase){
		if(definitions == null){
			definitions = new ArrayList<JSBase>();
		}
		definitions.add(jsBase);
	}
	public static void function(JSFunction function){
		if(functions == null){
			functions = new ArrayList<JSFunction>();
		}
		functions.add(function);
	}
	public static JSBase getDefObject(String name){
		if(name == null || name.trim().equals("")){
			return null;
		}
		if(definitions == null){
			return null;
		}
		JSBase res = null;
		for(JSBase jsBase : definitions){
			if(name.equals(jsBase.getName())){
				res = jsBase;
				break;
			}
		}
		return res;
	}
	
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
		if(loads != null){
			for(String js : loads){
				context.e("Ele.importJS(\""+js+"\");");
			}
		}
		if(definitions != null){
			for(JSBase jsBase : definitions){
				context.e(jsBase.getCode());
			}
		}
		
		context.e("function ele_init(){");
		context.e("Ele.load(function(){");
		
		JWebElement element = JWebElement.getElementById(context, "jweb_body");
		
		onCreateView(context, element);
		
		context.e("});};");
		if(functions != null){
			for(JSFunction function : functions){
				context.e(function.toCode());
			}
		}
	}
	
	public String getViewContent() {
		// TODO Auto-generated method stub
		return context.getContent();
	}
}
