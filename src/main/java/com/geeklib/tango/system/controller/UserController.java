package com.geeklib.tango.system.controller;

import java.util.List;

import javax.ws.rs.POST;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeklib.tango.system.entity.User;
import com.geeklib.tango.system.service.UserService;
import com.geeklib.tango.util.MD5Util;

@Controller
@RequestMapping("system/user")
public class UserController {
	
	@Autowired
	UserService userService;

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
	
	@GetMapping("/")
	@ResponseBody
	public List<User> listUser() {
		return userService.listUser();
	}
	
	@PostMapping("/")
	@ResponseBody
	public int saveUser(User user) {
		return userService.saveUser(user);
	}
}
