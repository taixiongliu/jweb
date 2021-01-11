package com.github.taixiongliu.jweb.window;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSBase;
import com.github.taixiongliu.jweb.core.JWebBasic;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebPopWindow;
import com.github.taixiongliu.jweb.core.utils.JWebAjax;
import com.github.taixiongliu.jweb.form.FormButtonWidget;
import com.github.taixiongliu.jweb.form.FormItem;
import com.github.taixiongliu.jweb.form.FormPasswordWidget;
import com.github.taixiongliu.jweb.handler.AjaxCallbackHandler;
import com.github.taixiongliu.jweb.handler.ItemClickHandler;

public class UpdatePasswdWindow extends JWebPopWindow{
	private FormPasswordWidget opasswd;
	private FormPasswordWidget npasswd;
	private FormPasswordWidget spasswd;
	
	public UpdatePasswdWindow(JWebContext context) {
		//width:320px; height:48*4=192;
		super(context, 320, 192);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init(){
		opasswd = new FormPasswordWidget(context,"原&nbsp;密&nbsp;码：");
		npasswd = new FormPasswordWidget(context,"新&nbsp;密&nbsp;码：");
		spasswd = new FormPasswordWidget(context,"确认密码：");
		addView(opasswd);
		addView(npasswd);
		addView(spasswd);
		
		FormButtonWidget fb = new FormButtonWidget(context, new ItemClickHandler(context, this.base()) {
			
			@Override
			public void onHandler(JWebContext ct1) {
				// TODO Auto-generated method stub
				UpdatePasswdWindow wd = (UpdatePasswdWindow)getProperty(UpdatePasswdWindow.this.getName());
				wd.hide();
			}
		}, new ItemClickHandler(context, this.base()) {
			
			@Override
			public void onHandler(JWebContext ct1) {
				// TODO Auto-generated method stub
				JWebBasic seesion = new JWebBasic(ct1, new Expression(ct1.getLocalStorage("session")));
				JWebBasic json = new JWebBasic(ct1, new Expression(ct1.jsonParse(seesion)));
			
				ct1.formValidate(opasswd, npasswd, spasswd);
				ct1.e(whenPasswdNotEquals(npasswd, spasswd));
				JWebAjax ajax = new JWebAjax(ct1);
				ajax.addParameter(new JSBase("opasswd", opasswd.getValue()));
				ajax.addParameter(new JSBase("npasswd", npasswd.getValue()));
				ajax.addParameter(new JSBase("sid", json.getProperty("sid")));
				ajax.request("upd_password.jweb", new AjaxCallbackHandler(context) {
					
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
		addView(fb);
		
		setTitle("密码修改");
	}
	
	public String whenPasswdNotEquals(FormItem npasswd, FormItem spasswd){
		StringBuilder sb = new StringBuilder();
		sb.append("if(").append(npasswd.getValue().getExp()).append("!=").append(spasswd.getValue().getExp())
		.append("){alert('两次输入密码不一致');return;}");
		return sb.toString();
	}
}
