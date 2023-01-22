package com.jang.dojoAndNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.dojoAndNinjas.models.Ninja;

@Repository
public interface NinjasRepo extends CrudRepository<Ninja, Long>{
List<Ninja> findAll(); 
}
