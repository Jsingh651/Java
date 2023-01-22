package com.jang.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.mvc.models.burgerModels;
import com.jang.mvc.services.burgerService;

@Controller
public class burgerController {

private final burgerService burgerS;

	public burgerController(burgerService burgerS) {
		this.burgerS = burgerS;
	}
	

	
	@PostMapping("/burger/form")
	public String form(	@Valid @ModelAttribute("burger") burgerModels burger, BindingResult result) {
	if(result.hasErrors()) {
		return "index.jsp";
	}
	burgerS.createBurger(burger); 
		return "redirect:/";		
	}
	

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("burger") burgerModels burger) {
        List<burgerModels> burgers = burgerS.allBurgers();
        model.addAttribute("burgers", burgers);
        
        return "index.jsp";
    }
    
    @RequestMapping(value="/edit/burger/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("burger") burgerModels burger, BindingResult result, @PathVariable("id") Long id, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("burger", burger);
            return "edit.jsp";
        }
        burger.setId(id);
        burgerS.editBurger(burger); 
        return "redirect:/";		
    }
 
    @RequestMapping(value="/api/burger/{id}", method=RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        burgerModels burger = burgerS.findburger(id);
        model.addAttribute("burger", burger);
        return "edit.jsp";
    }

   
}
  