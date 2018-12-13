package com.geeklib.tango.features.mapper;

import com.geeklib.tango.features.entity.SoftwareType;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SoftwareTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SoftwareType record);

    int insertSelective(SoftwareType record);

    @Select("select * from software_type")
    List<SoftwareType> listSoftwareType();

    SoftwareType selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(SoftwareType record);

    int updateByPrimaryKey(SoftwareType record);
}