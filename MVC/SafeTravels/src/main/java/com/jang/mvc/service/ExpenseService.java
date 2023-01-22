package com.jang.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.mvc.models.ExpenseModel;
import com.jang.mvc.repository.ExpenseRepo;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	public List<ExpenseModel> allExpenses(){
		return expenseRepo.findAll();
	}
	
	public ExpenseModel createExpense(ExpenseModel expenseCreator) {
		return expenseRepo.save(expenseCreator);
	}
	public ExpenseModel updateExpense(ExpenseModel E) {
		return expenseRepo.save(E);
	}
	
	public void delete(Long id) {
	    expenseRepo.deleteById(id);
	}
	
	public ExpenseModel findExpense(Long id) {
		Optional<ExpenseModel> optionaExpense = expenseRepo.findById(id);
		
		if (optionaExpense.isPresent()) {
			return optionaExpense.get();
		}
		
		else {
			return null;
			 }
		}
}
