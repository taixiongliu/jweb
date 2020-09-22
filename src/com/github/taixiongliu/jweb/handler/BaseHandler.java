package com.github.taixiongliu.jweb.handler;

import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWeb;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebFunction;
import com.github.taixiongliu.jweb.event.EventHandler;
import com.github.taixiongliu.jweb.event.IFunction;

public abstract class BaseHandler implements EventHandler{
	protected JWebFunction function;
	private JSBase[] properties;
	private JWebContext rootContext;
	public BaseHandler(JWebContext context, String parameter) {
		// TODO Auto-generated constructor stub
		setContext(context);
		init(parameter, null);
	}
	public BaseHandler(JWebContext context, String parameter, String prefix) {
		// TODO Auto-generated constructor stub
		setContext(context);
		init(parameter, prefix);
	}
	public BaseHandler(JWebContext context, String parameter, JSBase... properties) {
		// TODO Auto-generated constructor stub
		setContext(context);
		this.properties = properties;
		init(parameter, null);
	}
	public BaseHandler(JWebContext context, String parameter, String prefix, JSBase... properties) {
		// TODO Auto-generated constructor stub
		setContext(context);
		this.properties = properties;
		init(parameter, prefix);
	}
	public void setContext(JWebContext context){
		this.rootContext = context;
	}
	private void init(String parameter, String prefix){
		if(prefix == null){
			function = new JWebFunction(new IFunction() {
				
				@Override
				public void onCallBack(JWebContext context) {
					// TODO Auto-generated method stub
					onHandler(context);
				}
			}, parameter);
		}else{
			function = new JWebFunction(new IFunction() {
				
				@Override
				public void onCallBack(JWebContext context) {
					// TODO Auto-generated method stub
					onHandler(context);
				}
			}, parameter, prefix);
		}
		
		if(properties != null && properties.length > 0){
			for(JSBase base : properties){
				function.addProperty(base);
			}
		}
		function.load();
		//replace context back.
		if(properties != null && properties.length > 0){
			for(JSBase base : properties){
				if(base == null){
					continue;
				}
				Object value = base.getValue();
				if(base.getName() == null || value == null){
					continue;
				}
				
				if(value instanceof JWeb){
					((JWeb)value).setContext(this.rootContext);
				}
			}
		}
	}
	@Override
	public String toCode() {
		// TODO Auto-generated method stub
		return function.toFunctionString();
	}
	public Object getProperty(String name){
		if(properties == null || properties.length < 1){
			return null;
		}
		Object value = null;
		for(JSBase base : properties){
			if(base.getName().equals(name)){
				value = base.getValue();
				break;
			}
		}
		return value;
	}
}
