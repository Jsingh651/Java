package com.jang.DakichiCore;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		ArrayList <String> fruits = new ArrayList <String>();
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
		fruits.add("Dragonfruit");
		fruits.add("Apple");
		fruits.add("Durian");
		fruits.add("rambutan");
		
		model.addAttribute("fruits", fruits);
		return "index.jsp";
	}
}
