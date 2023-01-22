package com.jang.userReg.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jang.userReg.models.LoginUser;
import com.jang.userReg.models.User;
import com.jang.userReg.service.UserService;

@Controller
public class MainController {
	    // Add once service is implemented:
	     @Autowired
	     private UserService userServ;
	    
	    @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    	userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        User createdUser = userServ.createUser(newUser);
	        session.setAttribute("userId", createdUser.getId());
	        return "redirect:/home";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	    	User loggedUser = userServ.login(newLogin, result);
	    	
	        if(loggedUser == null) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        session.setAttribute("userId", loggedUser.getId());
	        return "redirect:/home";
	    }
	    
	    
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.removeAttribute("userId");
	    	return "redirect:/";
	    }
	    
	    @RequestMapping("/home")
	    public String homePage(Model model, HttpSession session) {
	    	Long userId = (Long) session.getAttribute("userId");
	       model.addAttribute("user", userServ.findUser(userId));
	            return "new.jsp";
	        }
	    }
	    
	    
	    
	    
	

