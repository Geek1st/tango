package com.geeklib.tango.features.mapper;

import com.geeklib.tango.features.entity.Software;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SoftwareMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Software record);

    int insertSelective(Software record);

    
    @Select("select * from software where software_type_id = #{softwareTypeId}")
    List<Software> listSoftware(int softwareTypeId);

    Software selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Software record);

    int updateByPrimaryKey(Software record);
}