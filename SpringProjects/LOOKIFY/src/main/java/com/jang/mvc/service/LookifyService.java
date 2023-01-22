package com.jang.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.mvc.models.LookifyModels;
import com.jang.mvc.repository.LookifyRepo;

@Service
public class LookifyService {

	@Autowired
	private LookifyRepo lookifyRepo;
	
	// FINDS ALL
	public List <LookifyModels> allSongs() {
		return lookifyRepo.findAll();
		}
	  public List<LookifyModels> getSongsByRatingsDesc() {
		    return lookifyRepo.findAllByOrderByRatingsDesc();
		  }
	  public List<LookifyModels> findByArtist(String artist) {
			return lookifyRepo.findByArtistContaining(artist);
		}
	  
	
	//	CREATES A SONG
	public LookifyModels createSong(LookifyModels song) {
		return lookifyRepo.save(song);
	}

	// DELETES A SONG	
	public void delete(Long id) {
		lookifyRepo.deleteById(id);
	}
	
	
	// SHOWS ONE SONG
	public LookifyModels findSong(Long id) {
		Optional<LookifyModels> optionalSong = lookifyRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	
	
}
