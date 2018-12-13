package com.geeklib.tango.features.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.geeklib.tango.features.entity.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);


    Project selectByPrimaryKey(Long id);
    
    @Select("select * from project")
    List<Project> listProject();
    
    @Select("select * from project where id = #{id}")
    Project getProjectById(long id);


    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}