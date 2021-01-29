package com.github.taixiongliu.jweb.application.views;

import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebHLayout;
import com.github.taixiongliu.jweb.core.JWebImage;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebMenuLabel;
import com.github.taixiongliu.jweb.core.views.JWebMasking;
import com.github.taixiongliu.jweb.handler.ClickHandler;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;
import com.github.taixiongliu.jweb.opts.MenuLabelOpts;

public class AppcompatTopView extends JWebLayout{
	private JWebImage bimg;
	public AppcompatTopView(JWebContext context, JWebMasking masking, Session session, ClickHandler handler) {
		// TODO Auto-generated constructor stub
		super(context, "topView", "jweb_admin_top_view", true);
		initView(context, masking, session, handler	);
	}
	
	private void initView(JWebContext context, JWebMasking masking, Session session, ClickHandler handler){
		
		JWebLayout bar = new JWebLayout(context, "jweb_admin_top_bar_view");
		bimg = new JWebImage(context, "img/chevronsLeft.png", "jweb_admin_top_bar_icon"); 
		bar.addView(bimg);
		bar.onClick(handler);
		
		addView(bar);
		
		JWebHLayout menu = new JWebHLayout(context, "jweb_admin_top_menu_view");
		MenuLabelOpts opt1 = new MenuLabelOpts();
		opt1.setText("首页");
		opt1.setIcon("img/shouye.png");
		opt1.setOnItemClick(new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext context) {
				// TODO Auto-generated method stub
				context.log("home page.");
			}
		});
		MenuLabelOpts opt2 = new MenuLabelOpts();
		opt2.setText("关于");
		
		MenuLabelOpts opt3 = new MenuLabelOpts();
		opt3.setText("案例");
		opt3.setChildren(childs(context));
		opt3.setMasking(masking);
		JWebMenuLabel mn_home = new JWebMenuLabel(context, opt1);
		JWebMenuLabel mn_about = new JWebMenuLabel(context, opt2);
		JWebMenuLabel mn_case = new JWebMenuLabel(context, opt3);
		
		menu.addView(mn_home);
		menu.addView(mn_about);
		menu.addView(mn_case);
		
		addView(menu);
	}
	
	public void showClose(){
		bimg.setUrl("img/chevronsLeft.png");
	}
	public void showExpand(){
		bimg.setUrl("img/chevronsRight.png");
	}
	public void setPaddingLeft(int left){
		context.e(bimg.getEle().getExp()+".style.paddingLeft="+left+"\"px\"");
	}
	
	public JSArray childs(JWebContext context){
		JSArray jsArray  = new JSArray();
		JSObject jo1 = new JSObject();
		jo1.putProperty("id", 1);
		JSObject jo2 = new JSObject();
		jo2.putProperty("id", 2);
		JSObject jo3 = new JSObject();
		jo3.putProperty("id", 3);
		MenuLabelOpts cds = new MenuLabelOpts();
		cds.setText("案例1");
		cds.setData(jo1);
		cds.setOnItemClick(new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				ct.log("111");
			}
		});
		
		MenuLabelOpts cds2 = new MenuLabelOpts();
		cds2.setText("案例2");
		cds2.setData(jo2);
		cds2.setOnItemClick(new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				ct.log("2222");
			}
		});
		
		MenuLabelOpts cds3 = new MenuLabelOpts();
		cds3.setText("案例2");
		cds3.setData(jo3);
		cds3.setOnItemClick(new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				ct.log("3333");
			}
		});
		
		jsArray.addProperty(cds.toJSObject());
		jsArray.addProperty(cds2.toJSObject());
		jsArray.addProperty(cds3.toJSObject());
		return jsArray;
	}
}
