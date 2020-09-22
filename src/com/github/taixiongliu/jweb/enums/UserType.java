package com.github.taixiongliu.jweb.enums;

public enum UserType {
	SUPPER(1),ADMIN(2),OPERATE(3),USER(4),BROWSE(5);
	private int value;
	private UserType(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	
	public int value(){
		return value();
	}
	
	public boolean equals(UserType userType){
		if(userType.value() == this.value){
			return true;
		}
		return false;
	}
	
	public static UserType create(int value){
		UserType userType = null;
		switch (value) {
		case 1:
			userType = SUPPER;
			break;
		case 2:
			userType = ADMIN;	
			break;
		case 3:
			userType = OPERATE;
			break;
		case 4:
			userType = USER;
			break;
		case 5:
			userType = BROWSE;
			break;

		default:
			break;
		}
		return userType;
	}
}
