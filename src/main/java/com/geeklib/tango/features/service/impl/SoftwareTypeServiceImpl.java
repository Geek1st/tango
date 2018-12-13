package com.geeklib.tango.features.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.SoftwareType;
import com.geeklib.tango.features.mapper.SoftwareTypeMapper;
import com.geeklib.tango.features.service.SoftwareTypeService;

@Component
public class SoftwareTypeServiceImpl implements SoftwareTypeService {

	@Resource
	SoftwareTypeMapper softwareTypeMapper;
	
	@Override
	public List<SoftwareType> listSoftwareType() {
		return softwareTypeMapper.listSoftwareType();
	}

}
