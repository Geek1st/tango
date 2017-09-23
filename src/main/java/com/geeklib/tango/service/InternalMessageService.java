package com.geeklib.tango.service;

import com.geeklib.tango.entity.InternalMessage;

/**
 * 站内信service接口
 * TODO
 * @author Geek1st
 * @version 1.0
 * @since 1.0
 */
public interface InternalMessageService {
	
	/**
	 * 保存InternalMessage
	 * @param internalMessage
	 */
	void saveInternalMessage(InternalMessage internalMessage);
}
