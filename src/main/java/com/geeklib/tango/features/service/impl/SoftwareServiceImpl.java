package com.geeklib.tango.features.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.Software;
import com.geeklib.tango.features.mapper.SoftwareMapper;
import com.geeklib.tango.features.service.SoftwareService;

@Component
public class SoftwareServiceImpl implements SoftwareService {

	@Resource
	SoftwareMapper softwareMapper;
	
	@Override
	public List<Software> listSoftware(int softwareTypeId) {
		return softwareMapper.listSoftware(softwareTypeId);
	}

}
