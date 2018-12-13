package com.geeklib.tango.el;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geeklib.tango.features.entity.Project;
import com.geeklib.tango.features.entity.ServerType;
import com.geeklib.tango.features.entity.Software;
import com.geeklib.tango.features.entity.SoftwareType;
import com.geeklib.tango.features.service.ProjectService;
import com.geeklib.tango.features.service.ServerTypeService;
import com.geeklib.tango.features.service.SoftwareService;
import com.geeklib.tango.features.service.SoftwareTypeService;

/**
 * 
 * @author Geek1st
 *
 */
@Component
public class Dictionary {

	static ProjectService projectService;
	static ServerTypeService serviceTypeSerivce;
	static List<ServerType> serverType;
	static SoftwareTypeService softwareTypeService;
	static SoftwareService softwareService;

	@Autowired
	public void setProjectSerivce(ProjectService projectService) {
		Dictionary.projectService = projectService;
	}

	@Autowired
	public void setServerTypeService(ServerTypeService serverTypeService) {
		Dictionary.serviceTypeSerivce = serverTypeService;
	}
	
	@Autowired
	public void setSoftwareTypeService(SoftwareTypeService softwareTypeService) {
		Dictionary.softwareTypeService = softwareTypeService;
	}
	
	@Autowired
	public void setSoftwareService(SoftwareService softwareService) {
		Dictionary.softwareService = softwareService;
	}

	public static List<Project> listProject() {
		return projectService.listProject();
	}

	public static List<ServerType> listServerType() {
		return serviceTypeSerivce.listServerType();
	}

	public static Project getProjectById(long id) {
		return projectService.getProjectById(id);
	}
	
	public static List<SoftwareType> listSoftwareType() {
		return softwareTypeService.listSoftwareType();
	}
	
	public static List<Software> listSoftware(int id){
		return softwareService.listSoftware(id);
	}
	
}
