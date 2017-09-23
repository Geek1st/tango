package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.SoftwareType;
import com.geeklib.tango.mapper.SoftwareTypeMapper;
import com.geeklib.tango.service.SoftwareTypeService;

@Component
public class SoftwareTypeServiceImpl implements SoftwareTypeService {

	@Resource
	SoftwareTypeMapper softwareTypeMapper;
	
	@Override
	public List<SoftwareType> listSoftwareType() {
		// TODO Auto-generated method stub
		return softwareTypeMapper.listSoftwareType();
	}

}
