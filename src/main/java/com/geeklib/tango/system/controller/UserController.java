package com.geeklib.tango.system.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeklib.tango.system.entity.User;
import com.geeklib.tango.util.MD5Util;

@Controller
@RequestMapping("system/user")
public class UserController {

	@RequestMapping("/gravatar")
	@ResponseBody
	public String gravatar() {
		
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		if(null != user) {
			return MD5Util.md5Hex(user.getUsername());
		}
		return MD5Util.md5Hex("");
	}
	
	@GetMapping("")
	public String view() {
		
		return "system/user/user";
	}
}
