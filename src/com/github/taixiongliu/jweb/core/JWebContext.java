package com.github.taixiongliu.jweb.core;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.base.JSArray;
import com.github.taixiongliu.jweb.base.JSObject;
import com.github.taixiongliu.jweb.base.Sentence;
import com.github.taixiongliu.jweb.core.base.JWebBase;
import com.github.taixiongliu.jweb.core.base.JWebEleJSView;
import com.github.taixiongliu.jweb.core.base.JWebView;
import com.github.taixiongliu.jweb.form.FormItem;

public abstract class JWebContext{
	public abstract String getNamePrefix();
	private StringBuilder sb;
	private int id;
	public JWebContext() {
		// TODO Auto-generated constructor stub
		sb = new StringBuilder();
		id = 0;
	}
	public void e(String code){
		sb.append(code);
	}
	
	public String getContent() {
		// TODO Auto-generated method stub
		return sb.toString();
	}
	
	public String named(){
		id ++;
		return getNamePrefix()+id;
	}
	
	public void formValidate(FormItem... forms){
		if(forms == null){
			return ;
		}
		for(FormItem item : forms){
			if(item == null){
				continue;
			}
			StringBuilder sb = new StringBuilder("if(");
			sb.append(item.getValue().getExp()).append("==''){")
			.append("alert('提交信息【"+item.getLabelText()+"】不能为空');")
			.append("return ;}");
			e(sb.toString());
		}
	}
	
	public void replaceLogin(){
		e(urlReplaceLogin().toCode());
	}
	public Sentence urlReplaceLogin(){
		return new Sentence("window.location.replace('login.html');");
	}
	
	public void replacePage(JWebBase session, Expression pageId, JSObject parameter){
		e(urlReplacePage(session, pageId, parameter).toCode());
	}
	public void replacePage(JWebBase session, int pageId, JSObject parameter){
		e(urlReplacePage(session, pageId, parameter).toCode());
	}
	/**
	 * 内部跳转
	 * @param session :login authorization session text.
	 * @param pageId :page ID
	 * @param parameter :empty input 'null' please.
	 */
	public Sentence urlReplacePage(JWebBase session, Expression pageId, JSObject parameter){
		if(parameter == null){
			parameter = new JSObject();
		}
		parameter.putProperty("sid", session);
		parameter.putProperty("page", pageId);
		String href = toUrl("index.html", parameter);
		return new Sentence("window.location.replace("+href+");");
	}
	/**
	 * 内部跳转
	 * @param session :login authorization session text.
	 * @param pageId :page ID
	 * @param parameter :empty input 'null' please.
	 */
	public Sentence urlReplacePage(JWebBase session, int pageId, JSObject parameter){
		if(parameter == null){
			parameter = new JSObject();
		}
		parameter.putProperty("sid", session);
		parameter.putProperty("page", pageId);
		String href = toUrl("index.html", parameter);
		return new Sentence("window.location.replace("+href+");");
	}
	/**
	 * 内部跳转
	 * @param session :login authorization session text.
	 * @param pageId :page ID
	 * @param parameter :empty input 'null' please.
	 */
	public void loadPage(JWebBase session, Expression pageId, JSObject parameter){
		e(urlLoadPage(session, pageId, parameter).toCode());
	}
	/**
	 * 内部跳转
	 * @param session :login authorization session text.
	 * @param pageId :page ID
	 * @param parameter :empty input 'null' please.
	 */
	public void loadPage(JWebBase session, int pageId, JSObject parameter){
		e(urlLoadPage(session, pageId, parameter).toCode());
	}
	
	public Sentence urlLoadPage(JWebBase session, Expression pageId, JSObject parameter){
		if(parameter == null){
			parameter = new JSObject();
		}
		parameter.putProperty("sid", session);
		parameter.putProperty("page", pageId);
		String href = toUrl("index.html", parameter);
		return new Sentence("window.location.href="+href+";");
	}
	
	public Sentence urlLoadPage(JWebBase session, int pageId, JSObject parameter){
		if(parameter == null){
			parameter = new JSObject();
		}
		parameter.putProperty("sid", session);
		parameter.putProperty("page", pageId);
		String href = toUrl("index.html", parameter);
		return new Sentence("window.location.href="+href+";");
	}
	
	public String toUrl(String url, JSObject object){
		StringBuilder sb = new StringBuilder();
		sb.append("'").append(url).append("?");
		int count = 0;
		for(String key : object.keySet()){
			Object value = object.get(key);
			if(count != 0){
				sb.append("&");
			}
			sb.append(key).append("=").append(urlFormat(value));
			count ++;
		}
		sb.append("'");
		return sb.toString();
	}
	public String urlFormat(Object value){
		if(value == null){
			return "";
		}
		if(value instanceof String){
			return value.toString();
		}
		if(value instanceof Expression){
			Expression temp = (Expression)value;
			return "'+("+temp.getExp()+")+'";
		}
		if(value instanceof JSObject){
			JSObject temp = (JSObject)value;
			return temp.toString();
		}
		if(value instanceof JSArray){
			JSArray temp = (JSArray)value;
			return temp.toString();
		}
		if(value instanceof JWebBase){
			JWebBase temp = (JWebBase)value;
			return "'+"+temp.getName()+"+'";
		}
		return value.toString();
	}
	
	public String jsonParse(Expression jsonText){
		return "JSON.parse("+jsonText.getExp()+")";
	}
	public String jsonParse(String jsonText){
		return "JSON.parse(\""+jsonText+"\")";
	}
	public String jsonParse(JWebBase jsonText){
		return "JSON.parse("+jsonText.getName()+")";
	}
	public String jsonStringify(JWebBase json){
		return "JSON.stringify("+json.getName()+")";
	}
	public String getLocalStorage(String storage){
		return "localStorage.getItem(\""+storage+"\")";
	}
	public String setLocalStorage(String storage, String value){
		return "localStorage.setItem(\""+storage+"\",\""+value+"\")";
	}
	public String setLocalStorage(String storage, JWebBase value){
		return "localStorage.setItem(\""+storage+"\",\""+value.getName()+"\")";
	}
	
	public void alert(Expression msg){
		e("alert("+msg.getExp()+");");
	}
	public void alert(String msg){
		e("alert('"+msg+"');");
	}
	public void alert(JWebEleJSView view){
		e("alert("+view.getEle()+");");
	}
	public void alert(JWebView view){
		e("alert("+view.getName()+");");
	}
	public void alert(JWebBase basic){
		e("alert("+basic.getName()+");");
	}
	public void log(String msg){
		e("console.log('"+msg+"');");
	}
	public void log(JWebEleJSView view){
		e("console.log("+view.getEle()+");");
	}
	public void log(JWebView view){
		e("console.log("+view.getName()+");");
	}
	public void log(JWebBase basic){
		e("console.log("+basic.getName()+");");
	}
}
