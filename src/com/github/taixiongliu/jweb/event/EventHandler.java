package com.github.taixiongliu.jweb.event;

import com.github.taixiongliu.jweb.core.JWebContext;

public interface EventHandler {
	public void onHandler(JWebContext context);
	public String toCode();
}
