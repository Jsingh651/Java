package com.jang.roaster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.roaster.models.Dorm;

@Repository
public interface DormsRepo extends CrudRepository <Dorm, Long> {
	List<Dorm> findAll();
}
