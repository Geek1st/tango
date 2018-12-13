package com.geeklib.tango.system.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geeklib.tango.system.entity.User;
import com.geeklib.tango.system.mapper.UserMapper;
import com.geeklib.tango.system.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	UserMapper userMapper;
	
	@Override
	public User getUserByUsername(String username) {
		return userMapper.getUserByUserName(username);
	}

	@Override
	public Set<String> getRoleNameByUserName(String username) {
		return userMapper.getRoleNameByUserName(username);
	}

}
