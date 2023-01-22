package com.jang.dojoAndNinjas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.dojoAndNinjas.models.Ninja;
import com.jang.dojoAndNinjas.repository.NinjasRepo;

//CREATE FIND DELETE EDIT
@Service
public class NInjaService {
	@Autowired
	private NinjasRepo ninjasRepo;

	public List<Ninja> findAllNinjas(){
		return ninjasRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjasRepo.save(ninja);
	}
}
