package com.jang.DakichiCore;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");

		if (count == null) {
			count = 0;
			}
			else {
			count+=1;
			}
		  session.setAttribute("count", count);
			return "index.jsp";
			
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		return "Counter.jsp";
	}
	
	@RequestMapping("/third")
	public String third(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
			}
			else {
			count+=2;
			}
		  session.setAttribute("count", count);
			return "Third.jsp";

	}
	@GetMapping("/clear")
	public String clearSession(HttpSession session) {
	  session.invalidate();
	  return "Counter.jsp";
	}

}


