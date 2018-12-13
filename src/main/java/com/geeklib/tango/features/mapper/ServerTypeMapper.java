package com.geeklib.tango.features.mapper;

import com.geeklib.tango.features.entity.ServerType;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ServerTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ServerType record);

    int insertSelective(ServerType record);


    ServerType selectByPrimaryKey(Integer id);
    
    @Select("select * from server_type")
    List<ServerType> listServerType();


    int updateByPrimaryKeySelective(ServerType record);

    int updateByPrimaryKey(ServerType record);
}