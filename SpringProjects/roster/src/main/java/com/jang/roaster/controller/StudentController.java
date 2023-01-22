package com.jang.roaster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jang.roaster.models.Student;
import com.jang.roaster.services.DormService;
import com.jang.roaster.services.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DormService dormService;
	
	@GetMapping("/studentShow")
	public String showStudentCreate(@ModelAttribute("student")Student student, Model model) {
		
		model.addAttribute("dorms", dormService.allDorms());
		return "studentCreate.jsp";
	}
	
	@PostMapping("/create/new/student")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dorms", dormService.allDorms());
			return "studentCreate.jsp";
		}
		
		return String.format("redirect:/dorm/%s",studentService.createStudent(student).getDorm().getId());
	}
}

