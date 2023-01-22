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

import com.jang.mvc.models.ExpenseModel;
import com.jang.mvc.service.ExpenseService;

@Controller
public class MainController {
	@Autowired
	private ExpenseService exservice;
	
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("expenseForm") ExpenseModel expenseForm) {
		List<ExpenseModel> expenses = exservice.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	


	@GetMapping("/edit")
	public String editShow() {
		return "edit.jsp";
	}

	@GetMapping("/show/{id}")
	public String showPage(@PathVariable("id") Long id, Model model) {
		ExpenseModel findexpense = exservice.findExpense(id);
		model.addAttribute("findexpense", findexpense);
		return "Show.jsp";
	}
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
	    ExpenseModel expense = exservice.findExpense(id);
	    model.addAttribute("expenseForm", expense);
	    return "update.jsp";
	}
	
	@RequestMapping(value="/edit/form/{id}", method=RequestMethod.POST)
	public String form(@Valid @ModelAttribute("expenseForm") 
						ExpenseModel expenseForm, BindingResult results, 
						@PathVariable("id") Long id, Model model) {

        if(results.hasErrors()) {
            model.addAttribute("expenseForm", expenseForm);
            return "update.jsp";
        }
        expenseForm.setId(id);
        exservice.updateExpense(expenseForm); 
        return "redirect:/";		
    }
	

	@RequestMapping(value="/delete/{id}", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable("id") Long id) {
	    exservice.delete(id);
	    return "redirect:/";
	}
	
	@PostMapping("/create/form")
	public String form(@Valid @ModelAttribute("expenseForm") 
	                    ExpenseModel expenseForm, BindingResult result, Model model) {

	    if (result.hasErrors()) {
	        model.addAttribute("expenseForm", expenseForm);
	        model.addAttribute("errors", result.getAllErrors());
	        return "index.jsp";
	    }
	    else {
	        exservice.createExpense(expenseForm);
	    }
	    return "redirect:/";
	}

}
