package com.github.taixiongliu.jweb.opts;

import com.github.taixiongliu.jweb.base.JSObject;

public class HLayoutOpts implements EntityOpts{
	private String sfloat;
	private String width;
	private String align;
	private String padding;
	public HLayoutOpts() {
		// TODO Auto-generated constructor stub
	}
	public HLayoutOpts(String width) {
		// TODO Auto-generated constructor stub
		this.width = width;
	}
	public String getSfloat() {
		return sfloat;
	}
	public void setSfloat(String sfloat) {
		this.sfloat = sfloat;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getPadding() {
		return padding;
	}
	public void setPadding(String padding) {
		this.padding = padding;
	}
	@Override
	public JSObject toJSObject() {
		// TODO Auto-generated method stub
		JSObject jo = new JSObject();
		if(sfloat != null){
			jo.putProperty("float", sfloat);
		}
		if(width != null){
			jo.putProperty("width", width);
		}
		if(align != null){
			jo.putProperty("align", align);
		}
		if(padding != null){
			jo.putProperty("padding", padding);
		}
		
		return jo;
	}
}
