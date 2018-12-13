package com.geeklib.tango.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geeklib.tango.system.entity.User;

@Controller
public class SignController {

	
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {
			return "redirect:/";
		}
		return "login";
	}
	
	@PostMapping("/logout")
	public String logout(User user) {
		SecurityUtils.getSubject().logout();
		return "login";
	}
}
