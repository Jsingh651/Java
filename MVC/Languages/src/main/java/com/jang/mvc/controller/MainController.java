package com.jang.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.mvc.models.LanguageModel;
import com.jang.mvc.service.LanguageService;

@Controller
public class MainController {
	
	@Autowired
	private LanguageService langservice;
	@GetMapping("/")
	public String home() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("LanguageAttribute") LanguageModel LanguageAttribute, Model model) {
		List<LanguageModel> languages = langservice.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String languageCreate(@Valid @ModelAttribute("LanguageAttribute") LanguageModel LanguageAttribute, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("LanguageAttribute", LanguageAttribute);
		}	
		else {
			langservice.createLanguage(LanguageAttribute);
		}
		return "redirect:/";
	}
	
	@GetMapping("/languages/{id}")
	public String showPage(@PathVariable("id") Long id, Model model) {
		LanguageModel findLanguage = langservice.findLanguage(id);
		model.addAttribute("findLanguage", findLanguage);
		return "show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model) {
		LanguageModel language = langservice.findLanguage(id);
		model.addAttribute("LanguageAttribute", language);
		return "edit.jsp";
	}

	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String editRoute(@Valid @ModelAttribute("LanguageAttribute") LanguageModel LanguageAttribute, BindingResult result,@PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
            model.addAttribute("LanguageAttribute", LanguageAttribute);
            return "edit.jsp";
        }
		LanguageAttribute.setId(id);
        langservice.updateLanguage(LanguageAttribute); 
        return "redirect:/";
	}
	
	@RequestMapping(value="/languages/{id}/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") Long id) {
		langservice.delete(id);
	    return "redirect:/";
	}
}

