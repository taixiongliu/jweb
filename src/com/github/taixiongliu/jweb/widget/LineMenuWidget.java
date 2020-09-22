package com.github.taixiongliu.jweb.widget;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebHLayout;
import com.github.taixiongliu.jweb.core.JWebIconLabel;
import com.github.taixiongliu.jweb.core.JWebLabel;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class LineMenuWidget extends JWebHLayout{

	public LineMenuWidget(JWebContext context) {
		super(context,"jweb_h_layout");
		// TODO Auto-generated constructor stub
	}
	
	public void addMenu(String icons, String text){
		JWebIconLabel menu = new JWebIconLabel(getContext(), getView(icons, text));
		addView(menu, getStyle());
	}
	public void addMenu(String icons, String text,ItemClickHandler handler){
		JWebIconLabel menu = new JWebIconLabel(getContext(), getView(icons, text,handler));
		addView(menu, getStyle());
	}
	
	public void addMenu(String text){
		JWebLabel menu = new JWebLabel(getContext(), text);
		addView(menu, getStyle());
	}
	
	private JSObject getView(String icons, String text){
		JSObject object = new JSObject();
		object.putProperty("icon", icons);
		object.putProperty("text", text);
		return object;
	}
	private JSObject getView(String icons, String text,ItemClickHandler handler){
		JSObject object = new JSObject();
		object.putProperty("icon", icons);
		object.putProperty("text", text);
		object.putProperty("onclick", handler);
		return object;
	}
	private JSObject getStyle(){
		JSObject obj = new JSObject();
		obj.putProperty("float", "right");
		obj.putProperty("padding", "0px 20px 0px 0px");
		return obj;
	}
}
