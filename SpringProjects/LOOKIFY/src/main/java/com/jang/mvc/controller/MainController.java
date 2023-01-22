package com.jang.mvc.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.mvc.models.LookifyModels;
import com.jang.mvc.service.LookifyService;


@Controller
public class MainController {
	
	@Autowired
	private LookifyService lookifyService;
@GetMapping("/")
public String index() {
	return "index.jsp";
}

@GetMapping("/dashboard")
public String home(@ModelAttribute("song") LookifyModels song, Model model) {
	List<LookifyModels> songs = lookifyService.allSongs();
	model.addAttribute("songs", songs);
	return "dashboard.jsp";
}

@GetMapping("/showAdd")
public String formShow(@ModelAttribute("song") LookifyModels song) {
	return "newSong.jsp";
}


@PostMapping("/addSong")
public String form(	@Valid @ModelAttribute("song") LookifyModels song, BindingResult result, Model model) {
if(result.hasErrors()) {
	model.addAttribute("song", song);
	return "newSong.jsp";
}
lookifyService.createSong(song); 
	return "redirect:/dashboard";		
}

@RequestMapping("/delete/{id}")
public String delete(@PathVariable("id") Long id) {
	lookifyService.delete(id);
	return "redirect:/dashboard";
	
}

//@RequestMapping(value="/delete/by/{id}", method=RequestMethod.DELETE)
//public String deleteby(@PathVariable("id") Long id, @PathVariable("artist") String artist, Model model) {
//    // Delete the song with the given id
//    lookifyService.delete(id);
//
//    // Find all songs by the given artist
//    List<LookifyModels> songs = lookifyService.findByArtist(artist);
//
//    // Add the list of songs to the model
//    model.addAttribute("songs", songs);
//
//    // Redirect to the same page
//    return "redirect:/seachSong/" + artist;
//}


@GetMapping("/showPage/{id}")
public String showPage(@PathVariable("id") Long id,Model model) {
	LookifyModels song = lookifyService.findSong(id);
	model.addAttribute("song", song);
	return "showSong.jsp";
}

@GetMapping("/topTen")
public String topTen(@ModelAttribute("song") LookifyModels song, Model model) {
	List<LookifyModels> songs = lookifyService.getSongsByRatingsDesc();
	model.addAttribute("songs", songs);
	return "topten.jsp";
}

@PostMapping("/dashboard")
public String dashboard(@RequestParam("artist") String artist, Model model) {
	model.addAttribute("artist", artist);
	return "redirect:/seachSong/"+artist;
}

@GetMapping("/seachSong/{artist}")
public String search(@PathVariable("artist") String artist, Model model) {
	List<LookifyModels> songs = lookifyService.findByArtist(artist);
	model.addAttribute("songs", songs);
	return "Searchsong.jsp";
}


}
