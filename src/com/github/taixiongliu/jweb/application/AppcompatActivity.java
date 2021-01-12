package com.github.taixiongliu.jweb.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.taixiongliu.jweb.ComponentBean;
import com.github.taixiongliu.jweb.JWebContextFactory;
import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.JWebAjaxLoad;
import com.github.taixiongliu.jweb.core.JWebAlert;
import com.github.taixiongliu.jweb.core.JWebBasic;
import com.github.taixiongliu.jweb.core.JWebConfirm;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebElement;
import com.github.taixiongliu.jweb.core.JWebImage;
import com.github.taixiongliu.jweb.core.JWebLabel;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebMenuList;
import com.github.taixiongliu.jweb.core.utils.JWebAjax;
import com.github.taixiongliu.jweb.core.utils.JWebWinInner;
import com.github.taixiongliu.jweb.core.views.JWebMasking;
import com.github.taixiongliu.jweb.handler.AjaxCallbackHandler;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;
import com.github.taixiongliu.jweb.handler.MenuListItemHandler;
import com.github.taixiongliu.jweb.handler.WindowResizeHandler;
import com.github.taixiongliu.jweb.widget.LineMenuWidget;
import com.github.taixiongliu.jweb.window.UpdatePasswdWindow;

public abstract class AppcompatActivity extends Activity{
	public abstract void onView(JWebContext context, JWebLayout root);
	public abstract String systemName();
	public abstract String userName();
	public abstract String bottomInfo();
	public abstract void onMenus(LineMenuWidget lineMenuWidget);
	
	protected JWebContext context;
	protected JWebElement root;
	protected JWebAjaxLoad ajaxLoad;
	protected JWebAlert alert;
	protected JWebConfirm confirm;
	
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
		
		//
		ajaxLoad = new JWebAjaxLoad(context);
		alert = new JWebAlert(context);
		confirm = new JWebConfirm(context);
		JWebWinInner winInner = new JWebWinInner(context);
		JWebMasking masking = new JWebMasking(context);
		root.appendChild(masking);
		//ajaxLoad.setMsg("自定义加载内容");
		//ajaxLoad.show();
		
		UpdatePasswdWindow updpass = new UpdatePasswdWindow(context);
				
		JWebLayout menuPanel = new JWebLayout(context, "jweb_menu_panel");
		JWebLayout topPanel = new JWebLayout(context, "jweb_top_panel");
		JWebLayout bottomPanel = new JWebLayout(context, "jweb_bottom_panel");
		
		//菜单头部
		JWebLayout systemLogoPanel = new JWebLayout(context, "jweb_system_logo_panel");
		JWebLayout systemLogoView = new JWebLayout(context, "jweb_system_logo_view");
		JWebLayout loginNameTxt = new JWebLayout(context, "jweb_login_name_txt");
		loginNameTxt.setHtml(userName());
		JWebImage systemLogoIcon = new JWebImage(context, "icons/icon_signal_fill.png", "jweb_system_logo_icon");
		systemLogoView.addView(systemLogoIcon);
		
		systemLogoPanel.setAlign("center");
		systemLogoPanel.addView(systemLogoView);
		systemLogoPanel.addView(loginNameTxt);
		
		//菜单列表
		JWebLayout menuListView = new JWebLayout(context, "jweb_system_menu_list_view");
		JWebLayout menuBlodDivider = new JWebLayout(context, "jweb_menu_blod_divider");
		
		
		JWebBasic innerHeight = winInner.getHeight();
		
		JWebMenuList menuList = new JWebMenuList(context, new MenuListItemHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				JWebBasic seesion = new JWebBasic(ct, new Expression(ct.getLocalStorage("session")));
				JWebBasic json = new JWebBasic(ct, new Expression(ct.jsonParse(seesion)));
//				
				JWebBasic sid = new JWebBasic(ct, json.getProperty("sid"));
				ct.loadPage(sid, getValue("id"),null);
			}
		});
		menuList.setHeightSub(innerHeight, 157);
		List<ComponentBean> components = JWebContextFactory.getInstance().getBeans();
		List<JSObject> jos = toMenus(bean, components);
		
		for(JSObject jo : jos){
			menuList.add(jo);
		}	
		winInner.addOnResizeHandler(new WindowResizeHandler(context, menuList.base()) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				JWebMenuList ml = (JWebMenuList)getProperty(menuList.getName());
				ml.setHeightSub(getHeight(), 157);
			}
		});
		
		menuListView.addView(menuBlodDivider);
		menuListView.addView(menuList);
		
		menuPanel.addView(systemLogoPanel);
		menuPanel.addView(menuListView);
		
		//top
		JWebLayout topLeft = new JWebLayout(context, "jweb_top_left_view");
		JWebLabel sysName = new JWebLabel(context, systemName(), "jweb_system_name_txt");
		topLeft.addView(sysName);
		JWebLayout topRight = new JWebLayout(context, "jweb_top_right_view");
		//Line menu widget.
		LineMenuWidget hLayout = new LineMenuWidget(context);
		hLayout.addMenu("icons/ic_exit.png", "安全退出",new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				JWebBasic seesion = new JWebBasic(ct, new Expression(ct.getLocalStorage("session")));
				JWebBasic json = new JWebBasic(ct, new Expression(ct.jsonParse(seesion)));
				JWebBasic sid = new JWebBasic(ct, json.getProperty("sid"));
				JWebAjax ajax = new JWebAjax(ct);
				JSBase base = new JSBase("sid", sid);
				ajax.addParameter(base);
				ajax.request("logout.jweb", new AjaxCallbackHandler(context) {
					
					@Override
					public void onHandler(JWebContext ct2) {
						// TODO Auto-generated method stub
						Expression json = toJson(ct2);
						whenCodeEquals(ct2, json, "errorCode",1000, ct2.urlReplaceLogin());
						alertMsg(ct2, json, "errorMsg");
					}
				});
			}
		});
		
		hLayout.addMenu("icons/ic_edit.png", "修改密码", new ItemClickHandler(context, updpass.base()) {
			
			@Override
			public void onHandler(JWebContext ct) {
				// TODO Auto-generated method stub
				//ct2.alert("sasa");
				UpdatePasswdWindow window = (UpdatePasswdWindow)getProperty(updpass.getName());
				window.show();
			}
		});
		hLayout.addMenu("欢迎您，"+userName());
		hLayout.addMenu("icons/ic_home.png", "首页",new ItemClickHandler(context) {
			
			@Override
			public void onHandler(JWebContext context) {
				// TODO Auto-generated method stub
				JWebBasic seesion = new JWebBasic(context, new Expression(context.getLocalStorage("session")));
				JWebBasic json = new JWebBasic(context, new Expression(context.jsonParse(seesion)));
//				
				JWebBasic sid = new JWebBasic(context, json.getProperty("sid"));
				context.loadPage(sid, 0, null);
			}
		});
		onMenus(hLayout);
		
		topRight.addView(hLayout);
		JWebLayout clObject = new JWebLayout(context, "ele_cl");
		topPanel.addView(topLeft);
		topPanel.addView(topRight);
		topPanel.addView(clObject);
		
		//bottom
		JWebLabel txtBottom = new JWebLabel(context, bottomInfo(), "jweb_bottom_info_txt");
		bottomPanel.setAlign("center");
		bottomPanel.addView(txtBottom);
		
		//content
		JWebLayout contentPanel = new JWebLayout(context, "jweb_content_panel");
		
		root.appendChild(menuPanel);
		root.appendChild(topPanel);
		root.appendChild(bottomPanel);
		root.appendChild(contentPanel);
		onView(context, contentPanel);
	}

	
	private List<JSObject> toMenus(ComponentBean page, List<ComponentBean> components){
		List<JSObject> objects = new ArrayList<JSObject>();
		
		//
//		object.putProperty(name, value);
		List<ComponentBean> list = new ArrayList<ComponentBean>();
		Map<Integer, List<ComponentBean>> map = new HashMap<Integer, List<ComponentBean>>();
		for(ComponentBean bean : components){
			//not menu bean.
			if(bean.getPid() < 0){
				continue;
			}
			//root menu bean.
			if(bean.getPid() == 0){
				list.add(bean);
				continue;
			}
			//children menu bean.
			List<ComponentBean> child = map.get(bean.getPid());
			if(child == null){
				child = new ArrayList<ComponentBean>();
			}
			child.add(bean);
			map.put(bean.getPid(), child);
		}
		//format
		for(ComponentBean root : list){
			JSObject jsObject = new JSObject();
			jsObject.putProperty("title", root.getMenuName());
			jsObject.putProperty("icon", root.getIcon());
			
			JSArray array = new JSArray();
			List<ComponentBean> children = map.get(root.getId());
			if(children != null){
				for(ComponentBean child : children){
					JSObject temp = new JSObject();
					temp.putProperty("id", child.getId());
					temp.putProperty("text", child.getMenuName());
					temp.putProperty("icon", child.getIcon());
					if(child.equals(page)){
						temp.putProperty("selected", true);
						jsObject.putProperty("expend", true);
					}
					array.addProperty(temp);
				}
			}
			
			jsObject.putProperty("children", array);
			objects.add(jsObject);
		}
		
		return objects;
	}
}
