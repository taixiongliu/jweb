package com.github.taixiongliu.jweb.opts;

import com.github.taixiongliu.jweb.base.JSObject;

public class VLayoutOpts implements EntityOpts{
	private String heigth;
	private String align;
	public String getHeigth() {
		return heigth;
	}
	public void setHeigth(String heigth) {
		this.heigth = heigth;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	@Override
	public JSObject toJSObject() {
		// TODO Auto-generated method stub
		JSObject jo = new JSObject();
		if(heigth != null){
			jo.putProperty("heigth", heigth);
		}
		if(align != null){
			jo.putProperty("align", align);
		}
		return jo;
	}

}
