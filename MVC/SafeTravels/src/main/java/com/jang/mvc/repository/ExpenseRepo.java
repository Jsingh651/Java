package com.jang.mvc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.mvc.models.ExpenseModel;

@Repository
public interface ExpenseRepo extends CrudRepository<ExpenseModel, Long> {
	List<ExpenseModel> findAll();
}
