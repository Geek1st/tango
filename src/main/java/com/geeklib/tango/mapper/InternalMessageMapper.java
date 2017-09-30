package com.geeklib.tango.mapper;

import com.geeklib.tango.entity.InternalMessage;
import com.geeklib.tango.entity.InternalMessageExample;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

@Component
public interface InternalMessageMapper extends BaseMapper<InternalMessage>{
	long countByExample(InternalMessageExample example);

	int deleteByExample(InternalMessageExample example);

	int deleteByPrimaryKey(Long id);

	int insert(InternalMessage record);

	@Insert("INSERT INTO internal_message (gmt_create, gmt_modified, receive_user_id, send_user_id, message, is_read) VALUES (NOW(), NOW(), #{receiveUserId}, #{sendUserId}, #{message}, 0);")

	int save(InternalMessage internalMessage);
	
	@SelectProvider(method = "listPm", type = pmMapper.class)
	List<InternalMessage> listInternalMessage();

	int insertSelective(InternalMessage record);

	List<InternalMessage> selectByExample(InternalMessageExample example);

	InternalMessage selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") InternalMessage record,
			@Param("example") InternalMessageExample example);

	int updateByExample(@Param("record") InternalMessage record, @Param("example") InternalMessageExample example);

	int updateByPrimaryKeySelective(InternalMessage record);

	int updateByPrimaryKey(InternalMessage record);
}