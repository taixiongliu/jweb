package com.github.taixiongliu.jweb.application;

import com.github.taixiongliu.hapi.http.HapiHttpRequest;
import com.github.taixiongliu.hapi.http.HapiHttpResponse;
import com.github.taixiongliu.hapi.route.HapiRouteType;
import com.github.taixiongliu.hapi.route.RequestMapping;

import io.netty.handler.codec.http.HttpHeaderNames;

public abstract class ApplicationRoute {
	@RequestMapping(value="*", type=HapiRouteType.PATH)
	public void jweb_root(HapiHttpRequest request, HapiHttpResponse response){
		String url = request.getUrl();
		if(url.endsWith(".html")){
			response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "text/html ");
		}
		if(url.endsWith(".css")){
			response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "text/css");
		}
		if(url.endsWith(".js")){
			response.setHead(HttpHeaderNames.CONTENT_TYPE.toString(), "application/javascript");
		}
		response.setContent("webcontent"+url);
	}
}
