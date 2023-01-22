package com.jang.DakichiCore;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
@GetMapping("/")
public String index(Model model) {
	return "index.jsp";
}
@GetMapping("/date")
public String date(Model model) {
	SimpleDateFormat dayNameFormat = new SimpleDateFormat("EEEE");
	SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
	SimpleDateFormat yearFormat = new SimpleDateFormat("Y");
	
	Date date = new Date();
	
	String dayNameString = dayNameFormat.format(date);
	String dayString = dayFormat.format(date);
	String monthString = monthFormat.format(date);
	String yearString = yearFormat.format(date);
	
	String newdate = dayNameString + ", " + dayString +", "+ "of "+ monthString + " " + yearString;
	model.addAttribute("newdate",newdate);
	return "date.jsp";
}

@GetMapping("/time")
public String time (Model model) {
	return "time.jsp";
}
}
