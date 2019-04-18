package com.antique.microserices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
		logger.info("====> ZuulLoggingFilter.run() method invoked");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		logger.info("====> ZuulLoggingFilter.shouldFilter() method invoked");
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request => {} \n Request URI => {}",request,request.getRequestURI());
		return true;
	}

	@Override
	public int filterOrder() {
		logger.info("====> ZuulLoggingFilter.filterOrder() method invoked");
		return 0;
	}

	@Override
	public String filterType() {
		logger.info("====> ZuulLoggingFilter.filterType() method invoked");
		return "pre";
	}

}
