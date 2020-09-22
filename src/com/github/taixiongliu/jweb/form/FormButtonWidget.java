package com.github.taixiongliu.jweb.form;

import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebHLayout;
import com.github.taixiongliu.jweb.core.JWebIconLabel;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;
import com.github.taixiongliu.jweb.opts.HLayoutOpts;
import com.github.taixiongliu.jweb.opts.IconLabelOpts;

public class FormButtonWidget extends JWebLayout{

	public FormButtonWidget(JWebContext context, ItemClickHandler cancelHandler, ItemClickHandler sureHandler) {
		super(context, "jweb_form_button_item_view");
		// TODO Auto-generated constructor stub
		init(cancelHandler, sureHandler);
	}

	private void init(ItemClickHandler cancelHandler, ItemClickHandler sureHandler){
		JWebLayout clayout = new JWebLayout(context,"");
		IconLabelOpts copts = new IconLabelOpts();
		copts.setText("取消");
		copts.setIcon("icons/ic_cancel.png");
		copts.setOnclick(cancelHandler);
		JWebIconLabel il_cancel = new JWebIconLabel(context, copts);
		HLayoutOpts opts = new HLayoutOpts();
		opts.setAlign("center");
		clayout.addView(il_cancel);
		
		JWebLayout slayout = new JWebLayout(context,"");
		IconLabelOpts sopts = new IconLabelOpts();
		sopts.setText("确认");
		sopts.setIcon("icons/ic_sure.png");
		sopts.setOnclick(sureHandler);
		JWebIconLabel il_sure = new JWebIconLabel(context, sopts);
		slayout.addView(il_sure);
		
		JWebHLayout hLayout = new JWebHLayout(context, "jweb_form_button_view");
		hLayout.addViewOpts(clayout,opts);
		opts.setPadding("0px 0px 0px 20px");
		opts.setSfloat("right");
		hLayout.addViewOpts(slayout,opts);
		setAlign("center");
		addView(hLayout);
	}
	
}
