package com.jang.roaster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.roaster.models.Dorm;
import com.jang.roaster.models.Student;
import com.jang.roaster.services.DormService;
import com.jang.roaster.services.StudentService;

@Controller
public class DormController {
	
	@Autowired
	private DormService dormService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("dorm") Dorm dorm, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "index.jsp";
	}
	
	@GetMapping("/create/dorm")	
	public String showCreateDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "showDorm.jsp";
	}
	
	@PostMapping("/create/new/dorm")
	public String createDorm(@Valid @ModelAttribute("dorm")Dorm dorm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dorm", dorm);
			return "showDorm.jsp";
		}
		else {
			dormService.createDorm(dorm);
			return "redirect:/";
		}
	}
	@GetMapping("/dorm/{id}")
	public String showOneDorm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("students", studentService.findAllStudents());
		return "dormShow.jsp";
	}
	
	@PutMapping("/add/new/{id}")
	public String addexisiting(@PathVariable("id") Long id, @RequestParam(value="studentId", required= false) Long studentId) {
		Student student = studentService.findStudent(studentId);
		studentService.magic(student, dormService.findDorm(id));
		return "redirect:/dorm/{id}";
	}
	
}
