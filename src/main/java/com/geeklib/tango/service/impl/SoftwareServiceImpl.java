package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.Software;
import com.geeklib.tango.mapper.SoftwareMapper;
import com.geeklib.tango.service.SoftwareService;

@Component
public class SoftwareServiceImpl implements SoftwareService {

	@Resource
	SoftwareMapper softwareMapper;
	
	@Override
	public List<Software> listSoftware(int softwareTypeId) {
		return softwareMapper.listSoftware(softwareTypeId);
	}

}
