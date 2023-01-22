package com.jang.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.mvc.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long> {
	List<LanguageModel> findAll();
}
