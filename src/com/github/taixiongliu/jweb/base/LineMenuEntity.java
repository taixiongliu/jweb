package com.github.taixiongliu.jweb.base;

public class LineMenuEntity {
	private String name;
	private String icon;
	public LineMenuEntity(String name) {
		// TODO Auto-generated constructor stub
		this(name, null);
	}
	public LineMenuEntity(String name, String icon) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
