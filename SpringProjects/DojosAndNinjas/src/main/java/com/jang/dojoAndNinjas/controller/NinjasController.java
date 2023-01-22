package com.jang.dojoAndNinjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jang.dojoAndNinjas.models.Dojo;
import com.jang.dojoAndNinjas.models.Ninja;
import com.jang.dojoAndNinjas.service.DojoService;
import com.jang.dojoAndNinjas.service.NInjaService;

@Controller
public class NinjasController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NInjaService ninjaService;
	
	
	@GetMapping("/ninja")
	public String ninjaIndex(@ModelAttribute("ninja")Ninja ninja, Model model) {
		
		List<Dojo> dojos = dojoService.allDojo();
		model.addAttribute("dojos", dojos);

		return "ninjaShow.jsp";
	}
	
	@PostMapping("/create/ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("ninja", ninja);
			return "ninjaShow.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
}
