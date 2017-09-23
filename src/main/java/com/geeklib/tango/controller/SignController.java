package com.geeklib.tango.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geeklib.tango.entity.User;

@Controller
@RequestMapping("/sign")
public class SignController {

	@RequestMapping("")
	public String login() {
		return "login";
	}

	@RequestMapping("login")
	public String login(User user, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

		try {
			subject.login(token);
			return "redirect:/";
		} catch (UnknownAccountException uae) {
			// 捕获未知用户名异常
			request.setAttribute("message", "用户名错误");
			return login();
		} catch (IncorrectCredentialsException ice) {
			// 捕获密码错误异常
			request.setAttribute("message", "密码错误");
			return login();
		} catch (ExcessiveAttemptsException eae) {
			// 捕获错误登录过多的异常
			request.setAttribute("message", "多次账户/密码错误");
			return login();
		} catch (AuthenticationException ae) {
			request.setAttribute("message", "未知错误");
			return login();
		}
	}
}
