package com.jang.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String home () {
		return "index.jsp";
	}
	
	
	
	@GetMapping("/show")
	public String showPage(HttpSession session, Model model) {
		String result = (String) session.getAttribute("quote");
		model.addAttribute("result", result);
		return "showPage.jsp";
	}
	
	@PostMapping("/formData")
	public String form(
			@RequestParam (value = "number") Integer number,
			@RequestParam (value = "city") String city,
			@RequestParam (value = "person") String person,
			@RequestParam (value = "hobby") String hobby,
			@RequestParam (value = "living") String living,
			@RequestParam (value = "message") String message,
			HttpSession session){		
			String quote = String.format("In %s years, you will live in %s with %s as your roomate %s for a living. The next time you see a %s , You will have good luck. Also, %s",
			number, city, person, hobby, living, message);
			session.setAttribute("quote", quote);
			return "redirect:/show";
			}
		}
