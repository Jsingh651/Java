package com.jang.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.mvc.models.burgerModels;
import com.jang.mvc.repositories.BurgersRepository;

@Service
public class burgerService {
	
	@Autowired
	private BurgersRepository burgersRepository;
	
	public List<burgerModels> allBurgers(){
		return burgersRepository.findAll();
	}
	
	public burgerModels createBurger(burgerModels burgers) {
		return burgersRepository.save(burgers);
	}
	public burgerModels editBurger(burgerModels b) {
		return burgersRepository.save(b);
	}
	public burgerModels findburger(Long id) {
		Optional<burgerModels> optionalBurger = burgersRepository.findById(id);
		
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		
		else {
			return null;
			 }
		
	}
}
