package com.geeklib.tango.features.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.Server;
import com.geeklib.tango.features.mapper.ServerMapper;
import com.geeklib.tango.features.service.ServerService;

@Component
public class ServerServiceImpl implements ServerService
{
	
	@Resource
	ServerMapper serverMapper;
	
	@Override
	public List<Server> listServer()
	{
		return serverMapper.listServer();
	}

	@Override
	public void insert(Server server)
	{
		serverMapper.insert(server);
	}
	
	public void delete(long id) {
		serverMapper.deleteByPrimaryKey(id);
	}
}
