package com.jang.ProductsAndCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.ProductsAndCategories.models.Project;
import com.jang.ProductsAndCategories.models.Task;
import com.jang.ProductsAndCategories.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	public List<Task> findAll(){
		return taskRepo.findAll();
	}
	
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Task findTask(Long id) {
		Optional<Task> optionalTask = taskRepo.findById(id);
		if(optionalTask.isPresent()) {
			return optionalTask.get();
		}else {
			return null;
		}
	} 
	
	public Task deleteTask(Long id) {
		Optional <Task> optionalTask = taskRepo.findById(id);
		if(optionalTask.isPresent()) {
			taskRepo.deleteById(id);
			return optionalTask.get();
		}
		return null;
	}
	
	
}
