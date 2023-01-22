package com.jang.dojoAndNinjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jang.dojoAndNinjas.models.Dojo;
import com.jang.dojoAndNinjas.service.DojoService;

@Controller
public class DojosController {

	@Autowired
	private DojoService dojoService;
	@GetMapping("/")
	public String index(@ModelAttribute("dojo")Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojo();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@PostMapping("/create/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result, Model model){
		if (result.hasErrors()) {
			model.addAttribute("dojo", dojo);
			return "index.jsp";
		}
		
		else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/showDojo/{id}")
	public String showOneDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "dojoShow.jsp";
	}
	
}
