package com.geeklib.tango.mapper;

import com.geeklib.tango.entity.ServerType;
import com.geeklib.tango.entity.ServerTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ServerTypeMapper {
    long countByExample(ServerTypeExample example);

    int deleteByExample(ServerTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServerType record);

    int insertSelective(ServerType record);

    List<ServerType> selectByExample(ServerTypeExample example);

    ServerType selectByPrimaryKey(Integer id);
    
    @Select("select * from server_type")
    List<ServerType> listServerType();

    int updateByExampleSelective(@Param("record") ServerType record, @Param("example") ServerTypeExample example);

    int updateByExample(@Param("record") ServerType record, @Param("example") ServerTypeExample example);

    int updateByPrimaryKeySelective(ServerType record);

    int updateByPrimaryKey(ServerType record);
}