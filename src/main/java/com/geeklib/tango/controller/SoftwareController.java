package com.geeklib.tango.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geeklib.tango.entity.Software;
import com.geeklib.tango.service.SoftwareService;
import com.geeklib.tango.websocket.Notification;

@Controller
@RequestMapping("/software")
public class SoftwareController
{
	@Autowired
	SoftwareService softwareService;
	
//	@ResponseBody
//	@RequestMapping("/getSoftwareType.do")
//	public List<SoftwareType> getSoftwareType()
//	{
//		return softwareService.selectSoftwareType();
//	}
//
//	@ResponseBody
//	@RequestMapping("/getSoftwareList.do")
//	public List<Software> getSoftware(int softwareTypeId)
//	{
//		return softwareService.getSoftwareList(softwareTypeId);
//	}
	
	@RequestMapping("")
	public String software()
	{
		return "software";
	}
	
	@RequestMapping("/listSoftware.do")
	@ResponseBody
	public List<Software> listSoftware(int softwareTypeId){
		
		return softwareService.listSoftware(softwareTypeId);
	}
}
