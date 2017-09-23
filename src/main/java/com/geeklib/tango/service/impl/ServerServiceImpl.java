package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.Server;
import com.geeklib.tango.mapper.ServerMapper;
import com.geeklib.tango.service.ServerService;

@Component
public class ServerServiceImpl implements ServerService
{
	
	@Resource
	ServerMapper serverMapper;
	
	@Override
	public List<Server> listServer()
	{
		return serverMapper.selectByExample(null);
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
