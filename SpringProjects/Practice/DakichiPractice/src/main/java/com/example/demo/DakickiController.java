package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dakichi")
public class DakickiController {
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endovers";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow(){
		return "Tomorrow, an oppurtunity will arise, so be sure to be open to new ideas.";
	}
}
