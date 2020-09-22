package com.github.taixiongliu.jweb.opts;

import com.github.taixiongliu.jweb.base.JSObject;

public class TextBoxOpts implements EntityOpts{

	private String style;
	private String hint;
	private String readOnly;
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	@Override
	public JSObject toJSObject() {
		// TODO Auto-generated method stub
		JSObject jo = new JSObject();
		if(style != null){
			jo.putProperty("style", style);
		}
		if(hint != null){
			jo.putProperty("hint", hint);
		}
		if(readOnly != null){
			jo.putProperty("readOnly", readOnly);
		}
		
		return jo;
	}
}
