package com.uibuilder.service;

import com.uibuilder.model.ProjectBean;
import com.uibuilder.model.Response;

public interface ProjectService {

	Response<String> createNewProject(ProjectBean projectBean);

	//Response<String> createNewPages(Pages pages);
	
	Response<String> updateProjectDetails(ProjectBean projectBean);

	Response<String> removeProject(Integer projectID);

	

}
