package com.github.taixiongliu.jweb.form;

import com.github.taixiongliu.jweb.base.Expression;
import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.JWebHLayout;
import com.github.taixiongliu.jweb.core.JWebLabel;
import com.github.taixiongliu.jweb.core.JWebTextBox;
import com.github.taixiongliu.jweb.opts.HLayoutOpts;

public class FormTextWidget extends JWebHLayout implements FormItem{
	private JWebLabel title;
	private JWebTextBox box;
	
	public FormTextWidget(JWebContext context, String text) {
		super(context, "jweb_form_text_view");
		// TODO Auto-generated constructor stub
		init(text);
	}
	private void init(String text){
		title = new JWebLabel(context, text,"jweb_form_text_txt");
		HLayoutOpts opts = new HLayoutOpts("80px");
		opts.setAlign("center");
		opts.setPadding("0 0 0 10px");
		addViewOpts(title, opts);
		box = new JWebTextBox(context);
		addView(box);
	}
	public JWebLabel getTitle() {
		return title;
	}
	public void setTitle(JWebLabel title) {
		this.title = title;
	}
	public JWebTextBox getBox() {
		return box;
	}
	public void setBox(JWebTextBox box) {
		this.box = box;
	}
	@Override
	public Expression getValue() {
		// TODO Auto-generated method stub
		return box.getValue();
	}
	@Override
	public String getLabelText() {
		// TODO Auto-generated method stub
		return title.getText();
	}
}
