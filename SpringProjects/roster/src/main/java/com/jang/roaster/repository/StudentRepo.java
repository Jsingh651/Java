package com.jang.roaster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.roaster.models.Student;

@Repository
public interface StudentRepo extends CrudRepository <Student, Long> {
	
	List<Student> findAll();
	List<Student> findByDormIdIs(Long id);
	
}
