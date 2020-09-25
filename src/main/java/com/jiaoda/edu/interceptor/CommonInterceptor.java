package com.jiaoda.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 部署路径属性名称
	 */
	public static final String CONTEXT_PATH = "base";
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest req,
			HttpServletResponse resp, Object handler,
			ModelAndView modelAndView) throws Exception {
		req.setAttribute("base", req.getContextPath());
		System.out.println(req.getServletPath());
		req.setAttribute("pagepath", req.getServletPath());
	}
}
