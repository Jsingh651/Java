package com.jang.helloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
@RequestMapping("/")
	public String index(@RequestParam(value="name", required = false)String searchQuery, @RequestParam(value="last_name", required = false)String searchQuery1, @RequestParam(value="times", required = false)String searchQuery2) {
		String greeting = " ";
		
		if (searchQuery == null || searchQuery1 == null) {
			return "Hello Human";
		}
		
		else{
			int times = Integer.parseInt(searchQuery2);
			for (int i = 0; i <= times; i++) {
			greeting += String.format( "<h1> Hello %s %s <br></h1>", searchQuery, searchQuery1) ;
		}
			return greeting;
	}
	}
}

