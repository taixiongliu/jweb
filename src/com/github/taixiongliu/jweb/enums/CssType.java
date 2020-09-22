package com.github.taixiongliu.jweb.enums;

public enum CssType {
	CLASS(1),
	ID(2),
	TAG(3);
	
	private int value;
	private CssType(int value){
		this.value = value;
	}
	
	public int value(){
		return value;
	}
	
	public boolean equals(CssType type){
		if(type.value() == value){
			return true;
		}
		return false;
	}
	
	public String toString(){
		if(value == 1){
			return ".";
		}
		if(value == 2){
			return "#";
		}
		if(value == 3){
			return "";
		}
		return null;
	}
	
	public static CssType format(int value){
		CssType type = null;
		switch (value) {
		case 1:
			type = CssType.CLASS;
			break;
		case 2:
			type = CssType.ID;
			break;
		case 3:
			type = CssType.TAG;
			break;

		default:
			break;
		}
		return type;
	}
}
