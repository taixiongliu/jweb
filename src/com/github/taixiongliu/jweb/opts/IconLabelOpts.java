package com.github.taixiongliu.jweb.opts;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class IconLabelOpts implements EntityOpts{

	private String icon;
	private String text;
	private ItemClickHandler onclick;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ItemClickHandler getOnclick() {
		return onclick;
	}
	public void setOnclick(ItemClickHandler onclick) {
		this.onclick = onclick;
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
		if(onclick != null){
			jo.putProperty("onclick", onclick);
		}
		return jo;
	}
}
