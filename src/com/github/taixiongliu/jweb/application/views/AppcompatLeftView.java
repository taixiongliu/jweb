package com.github.taixiongliu.jweb.application.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.taixiongliu.jweb.AuthorizationInfo;
import com.github.taixiongliu.jweb.ComponentBean;
import com.github.taixiongliu.jweb.JWebContextFactory;
import com.github.taixiongliu.jweb.Session;
import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebImage;
import com.github.taixiongliu.jweb.core.JWebLabel;
import com.github.taixiongliu.jweb.core.JWebLayout;
import com.github.taixiongliu.jweb.core.JWebMenuList;
import com.github.taixiongliu.jweb.core.JWebVLayout;
import com.github.taixiongliu.jweb.core.base.JWebBase;
import com.github.taixiongliu.jweb.core.base.JWebView;
import com.github.taixiongliu.jweb.handler.MenuListItemHandler;
import com.github.taixiongliu.jweb.handler.WindowResizeHandler;
import com.github.taixiongliu.jweb.opts.HLayoutOpts;

public class AppcompatLeftView extends JWebLayout{
	private JWebMenuList menu;
	public AppcompatLeftView(JWebContext context, Expression innerHeight, ComponentBean bean, Session session) {
		// TODO Auto-generated constructor stub
		super(context, "leftView", "jweb_admin_left_view", true);
		initView(context, innerHeight, bean, session);
	}
	
	private void initView(JWebContext context, Expression innerHeight, ComponentBean bean, Session session){
		AuthorizationInfo info = session.getEntity();
		//--top start.
		//logo
		JWebVLayout top = new JWebVLayout(context, "jweb_admin_left_top");
		JWebImage logo = new JWebImage(context, "icons/icon_user.png","jweb_admin_logo");
		HLayoutOpts centerOpts = new HLayoutOpts();
		centerOpts.setAlign("center");
		top.addViewOpts(logo, centerOpts);
		
		//name
		JWebLabel name = new JWebLabel(context,info.getName(),"jweb_admin_name");
		HLayoutOpts centerTopOpts = new HLayoutOpts();
		centerTopOpts.setAlign("center");
		centerTopOpts.setPadding("4px 0 0 0");
		top.addViewOpts(name, centerTopOpts);
		
		//role
		JWebLabel role = new JWebLabel(context,info.getUserType().toNameString(),"jweb_admin_role");
		top.addViewOpts(role, centerOpts);
		
		addView(top);
		//--top end.
		
		//--menu start.
		menu = new JWebMenuList(context, new MenuListItemHandler(context) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				JWebBase seesion = new JWebBase(ct, new Expression(ct.getLocalStorage("session")));
				JWebBase json = new JWebBase(ct, new Expression(ct.jsonParse(seesion)));
				
				JWebBase sid = new JWebBase(ct, json.getProperty("sid"));
				ct.loadPage(sid, getValue("id"),null);
			}
		});
		
		//180-16
		menu.setHeightSub(innerHeight, 196);
		List<ComponentBean> components = JWebContextFactory.getInstance().getBeans();
		List<JSObject> jos = toMenus(bean, components);
		
		for(JSObject jo : jos){
			menu.add(jo);
		}
		//-- menu end.
		
		addView(menu);
	}
	
	public WindowResizeHandler getHandler(){
		return new WindowResizeHandler(context, menu.base()) {
			
			@Override
			public void onHandler(JWebContext ct, JWebView view) {
				// TODO Auto-generated method stub
				JWebMenuList ml = (JWebMenuList)getProperty(menu.getName());
				ml.setHeightSub(getHeight(), 196);
			}
		};
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
					temp.putProperty("data", "{id:"+child.getId()+"}");
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
