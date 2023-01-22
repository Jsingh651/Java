package com.jang.omikuji;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

@GetMapping("/")
public String index() {
	return "redirect:/home";
}

@GetMapping("/home")
public String apple() {
	return "index.jsp";
	
}

@RequestMapping("/clear")
public String reset(HttpSession session) {
	session.invalidate();
	return "redirect:/home";
}

@PostMapping("/gold")
public String goldroute(HttpSession session, Model model,
		@RequestParam(value="farm", required = false)String farm,
		@RequestParam(value="Cave", required = false)String Cave,
		@RequestParam(value="House", required = false)String House,
		@RequestParam(value="Quest", required = false)String Quest,
		@RequestParam(value="Spa", required = false)String Spa
		
		) {
	SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm a");
	Integer gold = 0;
	ArrayList<String> actions = new ArrayList<>();
	
	if (session.getAttribute("gold") == null) {
		session.setAttribute("gold", 0);
		session.setAttribute("actions", actions);
	}
	else {
		gold = (Integer) session.getAttribute("gold");
		actions = (ArrayList<String>) session.getAttribute("actions");
		session.setAttribute("actions", actions);
	}
	
	
	if (farm != null) {
		Integer amount = new Random().nextInt(11) + 10;
		gold+= amount;
		session.setAttribute("gold", gold);
		actions.add(0, " <p style='color: green;'> You entered a farm and earned " + amount + " gold. (" + format.format(new Date()) + ") </p>");
		return "redirect:/home";
	}
	
	if (Cave != null) {
		Integer amount = new Random().nextInt(6) + 5;
		gold+= amount;
		session.setAttribute("gold", gold);
		actions.add(0, "<p style='color: green;'> You entered a farm and earned " + amount + " gold. (" + format.format(new Date()) + ")</p>");
		return "redirect:/home";
	}
	if (House != null) {
		Integer amount = new Random().nextInt(4) + 2;
		gold+= amount;
		session.setAttribute("gold", gold);
		actions.add(0, "<p style='color: green;'> You entered a farm and earned " + amount + " gold. (" + format.format(new Date()) + ")</p>");
		return "redirect:/home";
	}
	if (Quest != null) {
		Integer amount = new Random().nextInt(101) - 50;
		gold+= amount;
		session.setAttribute("gold", gold);
		
		if(amount<0) {
			actions.add(0, " <p style='color: red;'> You failed the quest and lost " + (amount * -1) + " gold. (" + format.format(new Date()) + ") </p>");
		}else {
			actions.add(0, "<p style='color: green;'> You completed the quest and earned " + amount + " gold. (" + format.format(new Date()) + ")</p>");
		}
		return "redirect:/home";

		
	}
	if (Spa != null) {
		Integer amount = new Random().nextInt(16) + 5;
		gold-= amount;
		session.setAttribute("gold", gold);
		actions.add(0,  " <p style='color: red;'> You entered a farm and lost " + amount + " gold. (" + format.format(new Date()) + ") </p>");
		return "redirect:/home";
	}
	
	model.addAttribute("gold", gold);
	model.addAttribute("actions", actions);

	return "redirect:/home";
}

}
