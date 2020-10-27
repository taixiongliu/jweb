package com.github.taixiongliu.jweb.opts;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class IconLabelOpts implements EntityOpts{

	private String icon;
	private String text;
	private ItemClickHandler onclick;
	private String style;
	private String focusStyle;
	private String textStyle;
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

	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getFocusStyle() {
		return focusStyle;
	}
	public void setFocusStyle(String focusStyle) {
		this.focusStyle = focusStyle;
	}
	public String getTextStyle() {
		return textStyle;
	}
	public void setTextStyle(String textStyle) {
		this.textStyle = textStyle;
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
		if(style != null){
			jo.putProperty("style", style);
		}
		if(focusStyle != null){
			jo.putProperty("focusStyle", focusStyle);
		}
		if(textStyle != null){
			jo.putProperty("textStyle", textStyle);
		}
		return jo;
	}
}
