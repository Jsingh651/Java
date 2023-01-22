package com.jang.roaster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.roaster.models.Dorm;
import com.jang.roaster.models.Student;
import com.jang.roaster.repository.StudentRepo;

@Service
public class StudentService {
	
	
	
	@Autowired
	private StudentRepo studentRepo;
	
	public List<Student> findAllStudents(){
		return studentRepo.findAll();
	}
	
	public List<Student> findByDorm(Long id){
		return studentRepo.findByDormIdIs(id);
	}
	
	public Student updateStudent(Student student){
		return studentRepo.save(student);
	}
	
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void magic(Student student, Dorm dorm) {
		student.setDorm(dorm);
		studentRepo.save(student);
	}
	

	public Dorm deleteStudent(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if(optionalStudent.isPresent()) {
			studentRepo.deleteById(id);
		}
		return null;
	}
	
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}else {
			return null;
		}
	}

}
