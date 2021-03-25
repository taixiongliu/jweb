package com.github.taixiongliu.jweb.application;

import java.util.ArrayList;
import java.util.List;

import com.github.taixiongliu.jweb.ComponentBean;
import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.application.views.AppcompatLeftView;
import com.github.taixiongliu.jweb.application.views.AppcompatTopView;
import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebAjaxLoad;
import com.github.taixiongliu.jweb.core.JWebAlert;
import com.github.taixiongliu.jweb.core.JWebConfirm;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebMenuLabel;
import com.github.taixiongliu.jweb.core.base.JWebBase;
import com.github.taixiongliu.jweb.core.base.JWebElement;
import com.github.taixiongliu.jweb.core.base.JWebView;
import com.github.taixiongliu.jweb.core.utils.JWebTimer;
import com.github.taixiongliu.jweb.core.utils.JWebWinInner;
import com.github.taixiongliu.jweb.core.views.JWebMasking;
import com.github.taixiongliu.jweb.handler.ClickHandler;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;
import com.github.taixiongliu.jweb.handler.TimerHandler;
import com.github.taixiongliu.jweb.opts.MenuLabelOpts;

public abstract class AppcompatActivity extends Activity{
	public abstract void onView(JWebContext context, JWebLayout root);
	public abstract String userName();
	public abstract String bottomInfo();
	public abstract String versionInfo();
	public abstract void onMenus(List<JWebMenuLabel> menus);
	
	protected JWebContext context;
	protected JWebElement root;
	protected JWebMasking masking;
	protected JWebAjaxLoad ajaxLoad;
	protected JWebAlert alert;
	protected JWebConfirm confirm;
	
	private List<JWebMenuLabel> menus;
	
	static{
		//定义全局js变量
		definition(new JSBase("leftView", null));
		definition(new JSBase("topView", null));
		definition(new JSBase("contentView", null));
		definition(new JSBase("bottomView", null));
		definition(new JSBase("menuExpand", true));
		definition(new JSBase("left", 0));
	}
	
	public AppcompatActivity(ComponentBean bean, Session session) {
		// TODO Auto-generated constructor stub
		super(bean, session);
	}

	@Override
	public void onCreateView(JWebContext context, JWebElement root) {
		// TODO Auto-generated method stub
		//cache
		this.context = context;
		this.root = root;
		
		//initialize masking
		masking = new JWebMasking(context);
		root.appendChild(masking);
		
		//initialize menu
		menus = new ArrayList<JWebMenuLabel>();
		MenuLabelOpts homeOpts = new MenuLabelOpts();
		homeOpts.setText("首页");
		homeOpts.setIcon("icons/icon_home.png");
		homeOpts.setOnItemClick(new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				JWebBase seesion = new JWebBase(ct, new Expression(ct.getLocalStorage("session")));
				JWebBase json = new JWebBase(ct, new Expression(ct.jsonParse(seesion)));
				
				JWebBase sid = new JWebBase(ct, json.getProperty("sid"));
				ct.loadPage(sid,0,null);
			}
		});
		JWebMenuLabel mn_home = new JWebMenuLabel(context, homeOpts);
		menus.add(mn_home);
		onMenus(menus);
		
		//
		ajaxLoad = new JWebAjaxLoad(context);
		alert = new JWebAlert(context);
		confirm = new JWebConfirm(context);
		JWebWinInner winInner = new JWebWinInner(context);
		
		JWebTimer close = new JWebTimer(context, new TimerHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				ct.e("if(left <= -240){return false;};left -= 24;leftView.ele.style.left = left+'px';"
						+ "var pleft = left + 240;topView.ele.style.paddingLeft = pleft+'px';"
						+ "bottomView.ele.style.paddingLeft = pleft+'px';contentView.ele.style.paddingLeft = pleft+'px';return true;");
			}
		});
		JWebTimer expand = new JWebTimer(context, new TimerHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				ct.e("if(left >= 0){return false;};left += 24;leftView.ele.style.left = left+'px';"
						+ "var pleft = left + 240;topView.ele.style.paddingLeft = pleft+'px';"
						+ "bottomView.ele.style.paddingLeft = pleft+'px';contentView.ele.style.paddingLeft = pleft+'px';return true;");
			}
		});
		
		//--自定义的开始
		AppcompatLeftView left = new AppcompatLeftView(context, winInner.getHeight(), bean, session);
		AppcompatTopView top = new AppcompatTopView(context, masking, session, new ClickHandler(context,close.base(),expand.base()) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				JWebTimer cls = (JWebTimer)getProperty(close.getName());
				JWebTimer eps = (JWebTimer)getProperty(expand.getName());
				if(view == null){
					ct.log("handler view undefined.");
					return ;
				}
				AppcompatTopView v = (AppcompatTopView)view;
				ct.e("if(menuExpand){");
				v.showExpand(ct);
				cls.execute();
				ct.e("}else{");
				v.showClose(ct);
				eps.execute();
				ct.e("}");
				ct.e("menuExpand = !menuExpand;");
			}
		}, menus, versionInfo());
		winInner.addOnResizeHandler(left.getHandler());
		
		JWebLayout bottomView = JWebLayout.inflate(context, "bottomView", "jweb_admin_bottom_view");
		bottomView.setAlign("center");
		bottomView.setHtml(bottomInfo());
		
		//content
		JWebLayout contentPanel = JWebLayout.inflate(context, "contentView", "jweb_admin_content_view");
		
		root.appendChild(left);
		root.appendChild(top);
		root.appendChild(bottomView);
		root.appendChild(contentPanel);
		onView(context, contentPanel);
	}
}
