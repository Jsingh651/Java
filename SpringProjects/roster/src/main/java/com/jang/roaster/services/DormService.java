package com.jang.roaster.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jang.roaster.models.Dorm;
import com.jang.roaster.repository.DormsRepo;

@Service
public class DormService {
	
	@Autowired
	private DormsRepo dormsRepo;
	
	
	public List <Dorm> allDorms() {
		return dormsRepo.findAll();
		}
	
	public Dorm createDorm(Dorm dorms) {
		return dormsRepo.save(dorms);
	}
	
	public Dorm updateDorm(Dorm dorm) {
		return dormsRepo.save(dorm);
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> optionalDorm = dormsRepo.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		}else {
			return null;
		}
	}

}
