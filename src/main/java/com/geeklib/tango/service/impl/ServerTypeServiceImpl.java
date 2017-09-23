package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.ServerType;
import com.geeklib.tango.mapper.ServerTypeMapper;
import com.geeklib.tango.service.ServerTypeService;

@Component
public class ServerTypeServiceImpl implements ServerTypeService {

	@Resource
	ServerTypeMapper serverTypeMapper;
	
	@Override
	public List<ServerType> listServerType() {
		
		return serverTypeMapper.listServerType();
	}

}
