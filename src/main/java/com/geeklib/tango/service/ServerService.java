package com.geeklib.tango.service;

import java.util.List;

import com.geeklib.tango.entity.Server;

public interface ServerService
{
	public List<Server> listServer();
	
	public void insert(Server server);
	
	public void delete(long id);
	
}
