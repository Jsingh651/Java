package com.jang.ProductsAndCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.ProductsAndCategories.models.Project;
import com.jang.ProductsAndCategories.models.Task;

@Repository
public interface TaskRepository extends CrudRepository <Task, Long>{
List<Task> findAll();
//List<Task> findAllByProject(Project project);
}
