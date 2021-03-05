package com.github.taixiongliu.jweb.event;

import com.github.taixiongliu.jweb.core.JWebContext;
import com.github.taixiongliu.jweb.core.base.JWebView;

public interface EventHandler {
	public void onHandler(JWebContext context, JWebView view);
	public String toCode();
}
