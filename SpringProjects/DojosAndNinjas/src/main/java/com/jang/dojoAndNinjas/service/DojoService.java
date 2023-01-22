package com.jang.dojoAndNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.dojoAndNinjas.models.Dojo;
import com.jang.dojoAndNinjas.repository.DojosRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojosRepo dojosRepo;
	
	public List <Dojo> allDojo() {
		return dojosRepo.findAll();
		}
	
	public Dojo createDojo(Dojo dojos) {
		return dojosRepo.save(dojos);
	}
	
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalSong = dojosRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	
	
}
