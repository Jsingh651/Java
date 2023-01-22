package com.jang.dojoAndNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.dojoAndNinjas.models.Dojo;

@Repository
public interface DojosRepo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
	
}
