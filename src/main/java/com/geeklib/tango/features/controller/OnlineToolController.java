package com.geeklib.tango.features.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlinetool")
public class OnlineToolController {

	@RequestMapping("")
	public String onlinetool() {
		return "onlineTool";
	}
}
