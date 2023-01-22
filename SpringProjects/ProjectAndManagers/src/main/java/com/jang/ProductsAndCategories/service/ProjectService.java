package com.jang.ProductsAndCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.ProductsAndCategories.models.Project;
import com.jang.ProductsAndCategories.models.User;
import com.jang.ProductsAndCategories.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public List <Project> allProjects (){
		return projectRepo.findAll();
		}
	
	
	public List<Project> getUnassignedProjects(User user){
		return projectRepo.findByMembersNotContains(user);
	}
	
	public List<Project> getMemberOrLeadProject(Long id){
		return projectRepo.findByLeadOrMember(id);
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	} 
 	
	public Project createProject(Project p) {
		return projectRepo.save(p);
	}
	
	public Project updateProject(Project p) {
		return projectRepo.save(p);
	}
	
	public Project deleteProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			projectRepo.deleteById(id);
			return optionalProject.get();
		}
		return null;
	} 

}
