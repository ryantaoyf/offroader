package com.offroader.http;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/**
 * HTTP请求拦截器
 * 
 * @author li.li
 * @date 2014-06-24
 * 
 */
class BaseHttpRequestInterceptor implements HttpRequestInterceptor {

	@Override
	public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {

		if (request != null) {
			request.setHeader("Accept-Encoding", HttpUtils.GZIP);
		}
	}

}
