package com.geeklib.tango.features.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.Project;
import com.geeklib.tango.features.mapper.ProjectMapper;
import com.geeklib.tango.features.service.ProjectService;

@Component
public class ProjectServiceImpl implements ProjectService {

	@Resource
	ProjectMapper projectMapper;
	
	public List<Project> listProject() {
		return projectMapper.listProject();
	}

	@Override
	public Project getProjectById(long id) {
		return projectMapper.getProjectById(id);
	}
}
