package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.InternalMessage;
import com.geeklib.tango.mapper.InternalMessageMapper;
import com.geeklib.tango.service.InternalMessageService;

/**
 * 站内信Service实现类
 * TODO
 * @author Geek1st
 * @version 1.0
 */
@Component
public class InternalMessageServiceImpl implements InternalMessageService {

	@Resource
	InternalMessageMapper internalMessageMapper; 
	@Override
	public void saveInternalMessage(InternalMessage internalMessage) {

		internalMessageMapper.save(internalMessage);
	}

	public List<InternalMessage> listInternalMessage(long userId){
		return null;
	}

	@Override
	public List<InternalMessage> listPrivateMessage(long userId) {
		// TODO Auto-generated method stub
		List<InternalMessage> internalMessages = internalMessageMapper.listObjects(InternalMessage.class);
		return internalMessages;
	}
}
