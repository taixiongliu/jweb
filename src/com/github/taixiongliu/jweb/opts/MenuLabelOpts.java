package com.github.taixiongliu.jweb.opts;

import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.views.JWebMasking;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class MenuLabelOpts implements EntityOpts{
	private String text;
	private String style;
	private String icon;
	private ItemClickHandler onItemClick;
	private JSArray children;
	private JWebMasking masking;
	private JSObject data; 

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public ItemClickHandler getOnItemClick() {
		return onItemClick;
	}

	public void setOnItemClick(ItemClickHandler onItemClick) {
		this.onItemClick = onItemClick;
	}

	public JSArray getChildren() {
		return children;
	}

	public void setChildren(JSArray children) {
		this.children = children;
	}

	public JWebMasking getMasking() {
		return masking;
	}

	public void setMasking(JWebMasking masking) {
		this.masking = masking;
	}

	public JSObject getData() {
		return data;
	}

	public void setData(JSObject data) {
		this.data = data;
	}

	@Override
	public JSObject toJSObject() {
		// TODO Auto-generated method stub
		JSObject jo = new JSObject();
		if(icon != null){
			jo.putProperty("icon", icon);
		}
		if(text != null){
			jo.putProperty("text", text);
		}
		if(onItemClick != null){
			jo.putProperty("onItemClick", onItemClick);
		}
		if(style != null){
			jo.putProperty("style", style);
		}
		if(children != null){
			jo.putProperty("children", children);
		}
		if(masking != null){
			jo.putProperty("masking", masking);
		}
		if(data != null){
			jo.putProperty("data", data);
		}
		return jo;
	}
}
