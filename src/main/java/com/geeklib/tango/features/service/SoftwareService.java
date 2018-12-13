package com.geeklib.tango.features.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.Software;

public interface SoftwareService
{
//	@Resource
//	SoftwareMapper softwareMapper;
//	
//	public List<SoftwareType> selectSoftwareType()
//	{
//		return softwareMapper();
//		return null;
//	}
//	
//	public List<Software> getSoftwareList(int softwareTypeId)
//	{
//		return softwareMapper.getSoftwareList(softwareTypeId);
//		
//		return null;
//	}
	
	public List<Software> listSoftware(int softwareTypeId);
}
