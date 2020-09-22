package com.github.taixiongliu.jweb.form;

import com.github.taixiongliu.jweb.core.JWebContext;

public class FormPasswordWidget extends FormTextWidget{

	public FormPasswordWidget(JWebContext context, String title) {
		super(context, title);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init(){
		getBox().setType("password");
	}
}
