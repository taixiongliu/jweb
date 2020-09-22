package com.github.taixiongliu.jweb.code;

import com.github.taixiongliu.jweb.base.JSObject;

public class JWebMenuListCode extends JWebEleJSCode{
	public JWebMenuListCode(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public String create(JSObject opts){
//		return "var "+name+" = new Ele.MenuList("+opts+");";
		return constructor("MenuList", opts);
	}
	public String setTile(String title){
		return codeFormat("title.setText", title);
	}
	public String add(JSObject datasources){
		return codeFormat("add", datasources);
	}
	public String setHeight(String height){
		return name+".ele.style.height = "+height+";";
	}
}
