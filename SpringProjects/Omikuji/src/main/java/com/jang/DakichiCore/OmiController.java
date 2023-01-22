package com.jang.DakichiCore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OmiController {

	@RequestMapping("/")
	public String index() {
	    return "home.jsp";
	}
    @RequestMapping(value="/home", method = RequestMethod.POST)
    public String home(
            @RequestParam(value="years") Integer years,
            @RequestParam(value="city") String city,
            @RequestParam(value="name") String name,
            @RequestParam(value="hobby") String hobby,
            @RequestParam(value="living") String living,
            @RequestParam(value="desc") String desc,
            RedirectAttributes redirectAttributes
            ) {
        redirectAttributes.addAttribute("years", years);
        redirectAttributes.addAttribute("city", city);
        redirectAttributes.addAttribute("name", name);
        redirectAttributes.addAttribute("hobby", hobby);
        redirectAttributes.addAttribute("living", living);
        redirectAttributes.addAttribute("desc", desc);
        return "redirect:/welcome";
    }
}
