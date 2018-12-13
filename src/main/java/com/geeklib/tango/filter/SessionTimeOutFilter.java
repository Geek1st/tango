package com.geeklib.tango.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.servlet.AdviceFilter;

public class SessionTimeOutFilter extends AdviceFilter {


	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			String header = ((HttpServletRequest)request).getHeader("X-Requested-With");

			if (StringUtils.equals(header, "XMLHttpRequest")) {
				((HttpServletResponse)response).setStatus(401);
				return false;
			}
		}
		return super.preHandle(request, response);
	}

}
