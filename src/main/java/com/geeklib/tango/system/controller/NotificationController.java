package com.geeklib.tango.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("notification")
public class NotificationController {
	
	@RequestMapping("")
	public String notificationCenter() {
		return "notification-center";
	}
}
