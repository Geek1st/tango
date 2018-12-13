package com.geeklib.tango.features.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeklib.tango.features.entity.Server;
import com.geeklib.tango.features.service.ServerService;
import com.geeklib.tango.websocket.Notification;

@Controller
@RequestMapping("/server")
public class ServerController
{
	@Resource
	ServerService serverService;
	
	@RequestMapping("")
	public String server() {
		
		return "server";
	}
	
	@RequestMapping("/listServer.do")
	@ResponseBody
	public List<Server> listServer()
	{
		return serverService.listServer();
	}
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public void insert(Server server) throws Exception{
		
		serverService.insert(server);
		Map<String,String> message = new HashMap<String,String>();
		message.put("title", "服务器新增通知");
		message.put("body", "用户 " + server.getUsername() + " 新增了 " + server.getName());
		Notification.broadcast(message);
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public void delete(@RequestBody List<Server> servers) {
		
		for (Server server : servers) {
			serverService.delete(server.getId());
		}
	}
}
