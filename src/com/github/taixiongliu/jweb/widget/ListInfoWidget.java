package com.github.taixiongliu.jweb.widget;

import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebHLayout;
import com.github.taixiongliu.jweb.core.JWebLabel;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebVLayout;

public class ListInfoWidget extends JWebLayout{

	public ListInfoWidget(JWebContext context) {
		super(context, "jweb_list_info_panel");
		// TODO Auto-generated constructor stub
	}

	public void addItemView(String title, String info, String text){
		JWebVLayout vLayout = new JWebVLayout(getContext());
		JWebHLayout hLayout = new JWebHLayout(getContext());
		JWebLabel lb_title = new JWebLabel(getContext(), title, "jweb_list_info_txt_title");
		JWebLabel lb_info = new JWebLabel(getContext(), info, "jweb_list_info_txt_info");
		JWebLabel lb_text = new JWebLabel(getContext(), text, "jweb_list_info_txt_text");
		JSObject object = new JSObject();
		object.putProperty("padding", "0 0 0 8px");
		hLayout.addView(lb_title);
		hLayout.addView(lb_info, object);
		vLayout.addView(hLayout);
		vLayout.addView(lb_text);
		vLayout.addView(new JWebLayout(getContext(), "jweb_h_divider"));
		
		addView(vLayout);
	}
}
