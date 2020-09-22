package com.github.taixiongliu.jweb.enums;

public enum ButtonType {
	BLUE("blue"),
	GREEN("green"),
	PINK("pink"),
	ORANGE("orange"),
	RED("red"),
	YELLOW("yellow");
	
	private String value;
	private ButtonType(String type) {
		// TODO Auto-generated constructor stub
		this.value = type;
	}
	
	public String value(){
		return value;
	}
	
	public boolean equals(ButtonType type){
		if(value.equals(type.value())){
			return true;
		}
		return false;
	}
	
	public static ButtonType format(String type){
		if(type == null || type.trim().equals("")){
			return null;
		}
		if(type.equals("blue")){
			return BLUE;
		}
		if(type.equals("green")){
			return GREEN;		
		}
		if(type.equals("pink")){
			return PINK;
		}
		if(type.equals("orange")){
			return ORANGE;
		}
		if(type.equals("red")){
			return RED;
		}
		if(type.equals("yellow")){
			return YELLOW;
		}
		return null;
	}
}
