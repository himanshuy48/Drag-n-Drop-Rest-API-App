package com.uibuilder.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uibuilder.model.ProjectBean;
import com.uibuilder.model.Response;
import com.uibuilder.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/project")
@Api(value="Project Controller")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@ApiOperation(value = "Add a new project")
	@PostMapping("createproject")
	public Response<String> createNewProject(@RequestBody ProjectBean projectBean){
		return projectService.createNewProject(projectBean);
	}
	
	@ApiOperation(value = "update project details")
	@PutMapping("updateproject")
	public Response<String> updateProjectDetails(@RequestBody ProjectBean projectBean){
		return projectService.updateProjectDetails(projectBean);
	}
	
	@ApiOperation(value = "Delete project")
	@DeleteMapping("deleteproject")
	public Response<String> removeProject(@PathParam("id") Integer projectID){
		return projectService.removeProject(projectID);
	}
	
//	@ApiOperation(value = "Add a new page into a project")
//	@PostMapping("createpages")
//	public Response<String> createNewPages( @RequestBody Pages pages){
//		return projectService.createNewPages(pages);
//	}

}
