package com.github.taixiongliu.jweb.application.views;

import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebImage;
import com.github.taixiongliu.jweb.core.JWebLabel;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebMenuList;
import com.github.taixiongliu.jweb.core.JWebVLayout;
import com.github.taixiongliu.jweb.handler.MenuListItemHandler;
import com.github.taixiongliu.jweb.opts.HLayoutOpts;

public class AppcompatLeftView {
	private JWebLayout layout;
	private JWebMenuList menu;
	public AppcompatLeftView(JWebContext context) {
		// TODO Auto-generated constructor stub
		initView(context);
	}
	
	private void initView(JWebContext context){
		layout = new JWebLayout(context,"jweb_admin_left_view");
		
		//--top start.
		//logo
		JWebVLayout top = new JWebVLayout(context, "jweb_admin_left_top");
		JWebImage logo = new JWebImage(context, "img/login_logo.png","jweb_admin_logo");
		HLayoutOpts centerOpts = new HLayoutOpts();
		centerOpts.setAlign("center");
		top.addViewOpts(logo, centerOpts);
		
		//name
		JWebLabel name = new JWebLabel(context,"张富贵","jweb_admin_name");
		HLayoutOpts centerTopOpts = new HLayoutOpts();
		centerTopOpts.setAlign("center");
		centerTopOpts.setPadding("4px 0 0 0");
		top.addViewOpts(name, centerTopOpts);
		
		//role
		JWebLabel role = new JWebLabel(context,"超级管理员","jweb_admin_role");
		top.addViewOpts(role, centerOpts);
		
		layout.addView(top);
		//--top end.
		
		menu = new JWebMenuList(context, new MenuListItemHandler(context) {
			
			@Override
			public void onHandler(JWebContext context) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
