package com.github.taixiongliu.jweb.application.views;

import java.util.List;

import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebHLayout;
import com.github.taixiongliu.jweb.core.JWebImage;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebMenuLabel;
import com.github.taixiongliu.jweb.core.base.JWebBase;
import com.github.taixiongliu.jweb.core.base.JWebView;
import com.github.taixiongliu.jweb.core.utils.JWebAjax;
import com.github.taixiongliu.jweb.core.views.JWebMasking;
import com.github.taixiongliu.jweb.handler.AjaxCallbackHandler;
import com.github.taixiongliu.jweb.handler.ClickHandler;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;
import com.github.taixiongliu.jweb.opts.MenuLabelOpts;
import com.github.taixiongliu.jweb.window.UpdatePasswdWindow;

public class AppcompatTopView extends JWebLayout{
	private JWebImage bimg;
	public AppcompatTopView(JWebContext context, JWebMasking masking, Session session, ClickHandler handler, List<JWebMenuLabel> menus, String version) {
		// TODO Auto-generated constructor stub
		super(context, "topView", "jweb_admin_top_view", true);
		initView(context, masking, session, handler, menus, version);
	}
	
	private void initView(JWebContext context, JWebMasking masking, Session session, ClickHandler handler, List<JWebMenuLabel> menus, String version){
		handler.bindView(this);
		JWebLayout bar = new JWebLayout(context, "jweb_admin_top_bar_view");
		bimg = new JWebImage(context, "icons/chevronsLeft.png", "jweb_admin_top_bar_icon"); 
		bar.addView(bimg);
		bar.onClick(handler);
		
		addView(bar);
		
		JWebHLayout menu = new JWebHLayout(context, "jweb_admin_top_menu_view");
		
		if(menus != null){
			for(JWebMenuLabel ml: menus){
				menu.addView(ml);
			}
		}
		
		addView(menu);
		
		UpdatePasswdWindow updpass = new UpdatePasswdWindow(context);
		
		JWebHLayout rMenu = new JWebHLayout(context, "jweb_admin_top_right_menu_view");
		MenuLabelOpts versionOpts = new MenuLabelOpts();
		versionOpts.setText("版本：V"+version);
		versionOpts.setStyle("jweb_admin_top_right_menu_txt");
		MenuLabelOpts menuOpts = new MenuLabelOpts();
		menuOpts.setIcon("icons/icon_min_user.png");
		menuOpts.setText(session.getEntity().getAccount());
		menuOpts.setChildren(initChild(context, updpass));
		menuOpts.setMasking(masking);
		JWebMenuLabel mn_account = new JWebMenuLabel(context, menuOpts);
		JWebMenuLabel mn_version = new JWebMenuLabel(context, versionOpts);
		
		rMenu.addView(mn_account);
		rMenu.addView(mn_version);
		
		addView(rMenu);
	}
	
	public void showClose(JWebContext ct){
		bimg.setContext(ct);
		bimg.setUrl("icons/chevronsLeft.png");
		bimg.setContext(context);
	}
	public void showExpand(JWebContext ct){
		bimg.setContext(ct);
		bimg.setUrl("icons/chevronsRight.png");
		bimg.setContext(context);
	}
	
	private JSArray initChild(JWebContext context, UpdatePasswdWindow updpass){
		JSArray jsArray  = new JSArray();
		MenuLabelOpts upOpts = new MenuLabelOpts();
		upOpts.setText("修改密码");
		upOpts.setOnItemClick(new ItemClickHandler(context,updpass.base()) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				UpdatePasswdWindow window = (UpdatePasswdWindow)getProperty(updpass.getName());
				window.show();
			}
		});
		MenuLabelOpts exitOpts = new MenuLabelOpts();
		exitOpts.setText("安全退出");
		exitOpts.setOnItemClick(new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				JWebBase seesion = new JWebBase(ct, new Expression(ct.getLocalStorage("session")));
				JWebBase json = new JWebBase(ct, new Expression(ct.jsonParse(seesion)));
				JWebBase sid = new JWebBase(ct, json.getProperty("sid"));
				JWebAjax ajax = new JWebAjax(ct);
				JSBase base = new JSBase("sid", sid);
				ajax.addParameter(base);
				ajax.request("logout.jweb", new AjaxCallbackHandler(context) {
					
					@Override
					public void onHandler(JWebContext ct2, JWebView view) {
						// TODO Auto-generated method stub
						Expression json = toJson(ct2);
						whenCodeEquals(ct2, json, "errorCode",1000, ct2.urlReplaceLogin());
						alertMsg(ct2, json, "errorMsg");
					}
				});
			}
		});
		jsArray.addProperty(upOpts.toJSObject());
		jsArray.addProperty(exitOpts.toJSObject());
		
		return jsArray;
	}
}
