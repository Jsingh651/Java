package com.jang.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.mvc.models.burgerModels;

@Repository
public interface BurgersRepository extends CrudRepository <burgerModels, Long> {
	List<burgerModels> findAll();
}
