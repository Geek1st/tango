package com.geeklib.tango.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.entity.Project;
import com.geeklib.tango.mapper.ProjectMapper;
import com.geeklib.tango.service.ProjectService;

@Component
public class ProjectServiceImpl implements ProjectService {

	@Resource
	ProjectMapper projectMapper;
	
	public List<Project> listProject() {
		return projectMapper.listProject();
	}

	@Override
	public Project getProjectById(long id) {
		// TODO Auto-generated method stub
		return projectMapper.getProjectById(id);
	}
}
