package com.jang.ProductsAndCategories.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.ProductsAndCategories.models.LoginUser;
import com.jang.ProductsAndCategories.models.Project;
import com.jang.ProductsAndCategories.models.Task;
import com.jang.ProductsAndCategories.models.User;
import com.jang.ProductsAndCategories.service.ProjectService;
import com.jang.ProductsAndCategories.service.TaskService;
import com.jang.ProductsAndCategories.service.UserService;


@Controller
public class MainController {

	
	@Autowired
	 private UserService userServ;
	
	@Autowired
	 private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/create/task")
	public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult results, @RequestParam("project_task")Long project_task,  Model model, HttpSession session) {
		System.out.println(project_task);
		if(results.hasErrors()) {
			model.addAttribute("task", task);
			return "task.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		Project project = projectService.findProject(project_task);
	    User user = userServ.findUser(userId);
	    
	    task.setTask_creator(user);
	    task.setProject_task(project);
	    taskService.createTask(task);
	    return "redirect:/see/task/" + project_task;
	}
	
	
	@GetMapping("/see/task/{id}")
	public String seeTask(@ModelAttribute("task") Task task, @PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.findProject(id);
		model.addAttribute("tasks", taskService.findAll());
		model.addAttribute("project", project);
		return "task.jsp";
	}
	
	
	@GetMapping("/leave/project/{id}")
	public String leaveTeam(@PathVariable("id")Long id, Model model, HttpSession session) {
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/home";
	    }
	    Project project = projectService.findProject(id);
	    User user = userServ.findUser(userId);
	  
	    project.getMembers().remove(user);
	    projectService.updateProject(project);
	    return "redirect:/home";
	}
	    
	

	

	
	@GetMapping("/show/Product/{id}")
	public String showProject(@PathVariable("id")Long id, Model model){
		model.addAttribute("project", projectService.findProject(id));
		return "projectShow.jsp";
	}
	
	@GetMapping("/show/project/create")
	public String showCreate(@ModelAttribute("project") Project project, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/home";
	    }
		return "showCreateProject.jsp";
	}
	
	@PostMapping("/create/project")
	public String postCreate(@Valid @ModelAttribute("project") Project project, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("project", project);
			return "showCreateProject.jsp";
		}
		projectService.createProject(project);
		return "redirect:/home";
	}
	
	@PostMapping("/update/project/{id}")
	public String udpatePost(@Valid @ModelAttribute("project") Project project,BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("project", project);
			return "udpateProject.jsp";
		}
		projectService.updateProject(project);
		return "redirect:/home";
	}
	
	
	
	@GetMapping("/edit/project/{id}")
	public String updateProject(@ModelAttribute("project") Project project, @PathVariable("id")Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.findProject(id));
		return "udpateProject.jsp";
	}
	
	@GetMapping("/home")
		public String homePage(Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			if (userId == null) {
				return "redirect:/";
			}
			User user = userServ.findUser(userId);

			model.addAttribute("user", userServ.findUser(userId));
			model.addAttribute("projects", projectService.allProjects());
		    model.addAttribute("unnasignedProjects", projectService.getUnassignedProjects(user));
		    model.addAttribute("leadOrMember", projectService.getMemberOrLeadProject(userId));
		        return "new.jsp";
		        }
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String index(Model model) {
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
	
	@RequestMapping("/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		Project project = projectService.findProject(id);
		
	    if (userId != project.getLead().getId()){
	    	return "redirect:/";
	    }
		projectService.deleteProject(id);
		return "redirect:/home";
	}
	
	
    
	@GetMapping("/join/project/{id}")
	public String joinTeam(@PathVariable("id")Long id, HttpSession session) {
	    Long userId = (Long) session.getAttribute("userId");

	    if (userId == null) {
	        return "redirect:/";
	    }
	    
	    Project project = projectService.findProject(id);
	    User user = userServ.findUser(userId);
	  
	    project.getMembers().add(user);
	    projectService.updateProject(project);
	    return "redirect:/home";
	}
	
}
