package com.geeklib.tango.features.service;

import java.util.List;

import com.geeklib.tango.features.entity.Server;

public interface ServerService
{
	public List<Server> listServer();
	
	public void insert(Server server);
	
	public void delete(long id);
	
}
