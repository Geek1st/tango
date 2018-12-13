package com.geeklib.tango.system.service;

import java.util.List;

import com.geeklib.tango.features.entity.InternalMessage;

/**
 * 站内信service接口
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
	
	/**
	 * 通过收件人ID来获取站内信
	 * @return 站内信集合
	 */
	List<InternalMessage> listPrivateMessage(long userId);
}
