package com.jang.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.mvc.models.LookifyModels;

@Repository
public interface LookifyRepo extends CrudRepository<LookifyModels,Long> {
List<LookifyModels> findAll();
List<LookifyModels> findAllByOrderByRatingsDesc();
List<LookifyModels> findByArtistContaining(String artist);




}
