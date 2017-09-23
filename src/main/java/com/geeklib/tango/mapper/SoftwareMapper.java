package com.geeklib.tango.mapper;

import com.geeklib.tango.entity.Software;
import com.geeklib.tango.entity.SoftwareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SoftwareMapper {
    long countByExample(SoftwareExample example);

    int deleteByExample(SoftwareExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Software record);

    int insertSelective(Software record);

    List<Software> selectByExample(SoftwareExample example);
    
    @Select("select * from software where software_type_id = #{softwareTypeId}")
    List<Software> listSoftware(int softwareTypeId);

    Software selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Software record, @Param("example") SoftwareExample example);

    int updateByExample(@Param("record") Software record, @Param("example") SoftwareExample example);

    int updateByPrimaryKeySelective(Software record);

    int updateByPrimaryKey(Software record);
}