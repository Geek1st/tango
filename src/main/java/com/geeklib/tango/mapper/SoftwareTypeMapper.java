package com.geeklib.tango.mapper;

import com.geeklib.tango.entity.SoftwareType;
import com.geeklib.tango.entity.SoftwareTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SoftwareTypeMapper {
    long countByExample(SoftwareTypeExample example);

    int deleteByExample(SoftwareTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SoftwareType record);

    int insertSelective(SoftwareType record);

    @Select("select * from software_type")
    List<SoftwareType> listSoftwareType();

    SoftwareType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SoftwareType record, @Param("example") SoftwareTypeExample example);

    int updateByExample(@Param("record") SoftwareType record, @Param("example") SoftwareTypeExample example);

    int updateByPrimaryKeySelective(SoftwareType record);

    int updateByPrimaryKey(SoftwareType record);
}