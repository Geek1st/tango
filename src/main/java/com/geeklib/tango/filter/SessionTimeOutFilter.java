package com.geeklib.tango.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.UserFilter;

public class SessionTimeOutFilter extends UserFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			String header = ((HttpServletRequest)request).getHeader("X-Requested-With");

			if (StringUtils.equals(header, "XMLHttpRequest")) {
				((HttpServletResponse)response).setStatus(401);
				return false;
			}
		}
		return super.onAccessDenied(request, response);
	}
}
