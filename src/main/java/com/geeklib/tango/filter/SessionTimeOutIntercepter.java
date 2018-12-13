package com.geeklib.tango.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 会话超时拦截器，处理ajax请求时超时返回视图的问题，需要配合ajax全局设置
 * 
 * @author Geek1st
 *
 */
@Component
public class SessionTimeOutIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!SecurityUtils.getSubject().isAuthenticated()) {
			String header = request.getHeader("X-Requested-With");

			if (StringUtils.equals(header, "XMLHttpRequest")) {
				response.setStatus(401);
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
}
