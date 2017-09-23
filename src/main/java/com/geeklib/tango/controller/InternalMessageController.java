package com.geeklib.tango.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geeklib.tango.entity.InternalMessage;
import com.geeklib.tango.service.InternalMessageService;

/**
 * 站内信控制器
 * @author Geek1st
 * @version 1.0
 * @since 1.0
 */
@Controller
@RequestMapping("internalMessage")
public class InternalMessageController {
	
	@Resource
	InternalMessageService internalMessageService;
	
	/**
	 * 发送站内信，当用户ID为<b>0</b>时进行站内广播
	 * @param internalMessage 站内信实体对象
	 */
	@RequestMapping("sendMessage")
	public void sendMessage(InternalMessage internalMessage) {
		internalMessageService.saveInternalMessage(internalMessage);
	}
}
