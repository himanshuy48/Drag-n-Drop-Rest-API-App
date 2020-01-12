package com.uibuilder.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uibuilder.entity.Project;
import com.uibuilder.model.ProjectBean;
import com.uibuilder.model.Response;
import com.uibuilder.repository.ProjectRepo;
import com.uibuilder.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepo projectRepo;
	
	@Override
	@Transactional
	public Response<String> createNewProject(ProjectBean projectBean) {
		Optional<Project> getProjectList = projectRepo.existsByProjectName(projectBean.getName());
		if(getProjectList.isPresent()) {
			return new Response<>(201, "project name already exits.");
		}else {
			Project project = new Project();
			project.setName(projectBean.getName());
			project.setClientId(projectBean.getClientId());
			projectRepo.save(project);
			return new Response<>(200, "project created successfully.");
		}
	}
	
	@Override
	@Transactional
	public Response<String> updateProjectDetails(ProjectBean projectBean) {
		Optional<Project> getProjectList = projectRepo.findById(projectBean.getId());
		if(getProjectList.isPresent()) {
			Project project = new Project();
			project.setName(projectBean.getName());
			project.setClientId(projectBean.getClientId());
			projectRepo.save(project);
			return new Response<>(200, "project details updated successfully.");
		}else {
			return new Response<>(201, "project doen't exist.");
		}
	}
	
	@Override
	@Transactional
	public Response<String> removeProject(Integer projectID) {
		projectRepo.deleteById(projectID);
		return new Response<>(200, "project deleted successfully.");
	}

	

//	@Override
//	@Transactional
//	public Response<String> createNewPages(Pages pages) {
//		return new Response<>(200, "page created successfully.");
//	}

	

}
