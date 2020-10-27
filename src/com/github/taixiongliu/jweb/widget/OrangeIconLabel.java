package com.github.taixiongliu.jweb.widget;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebIconLabel;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;
import com.github.taixiongliu.jweb.opts.IconLabelOpts;

public class OrangeIconLabel extends JWebIconLabel{
	public OrangeIconLabel(JWebContext context, String text, String icon, ItemClickHandler onclick) {
		super(context, init(text, icon, onclick));
		// TODO Auto-generated constructor stub
	}
	private static JSObject init(String text, String icon, ItemClickHandler onclick){
		IconLabelOpts btn_opts = new IconLabelOpts();
		btn_opts.setText(text);
		btn_opts.setIcon(icon);
		btn_opts.setOnclick(onclick);
		btn_opts.setStyle("jweb_orange_icon_label");
		btn_opts.setFocusStyle("jweb_orange_icon_label_focus");
		btn_opts.setTextStyle("jweb_common_icon_label_txt");
		return btn_opts.toJSObject();
	}
}
