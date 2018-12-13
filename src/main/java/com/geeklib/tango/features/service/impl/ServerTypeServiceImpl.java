package com.geeklib.tango.features.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.ServerType;
import com.geeklib.tango.features.mapper.ServerTypeMapper;
import com.geeklib.tango.features.service.ServerTypeService;

@Component
public class ServerTypeServiceImpl implements ServerTypeService {

	@Resource
	ServerTypeMapper serverTypeMapper;
	
	@Override
	public List<ServerType> listServerType() {
		
		return serverTypeMapper.listServerType();
	}

}
