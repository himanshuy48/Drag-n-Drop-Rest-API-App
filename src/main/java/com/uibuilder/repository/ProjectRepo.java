package com.uibuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uibuilder.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer>{

	@Query(value="select * from project_master p where p.name=:name", nativeQuery=true)
	Optional<Project> existsByProjectName(String name);
	
}
