package com.geeklib.tango.system.service;

import java.util.Set;

import com.geeklib.tango.system.entity.User;

public interface UserService {

	public User getUserByUsername(String username);
	
	public Set<String> getRoleNameByUserName(String username);
}
