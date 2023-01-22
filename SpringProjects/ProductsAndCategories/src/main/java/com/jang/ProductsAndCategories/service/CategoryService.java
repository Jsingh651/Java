package com.jang.ProductsAndCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.ProductsAndCategories.models.Categories;
import com.jang.ProductsAndCategories.models.Products;
import com.jang.ProductsAndCategories.repository.CategoriesRepository;

@Service
public class CategoryService {
	

	@Autowired
	CategoriesRepository categoryRepo;
	
	public Categories findCategory(Long id) {
		Optional<Categories> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	public List<Categories> specificCategory(Products c){
		return categoryRepo.findAllByProducts(c);
	}
	
	public List<Categories> nonspecificCategory(Products c){
		return categoryRepo.findByProductsNotContains(c);
	}
	
	public List <Categories> allCategories (){
		return categoryRepo.findAll();
		}
	
	public Categories createCategory (Categories categories) {
		return categoryRepo.save(categories);
	}
	
	public Categories updateCategory (Categories categories) {
		return categoryRepo.save(categories);
	}
	
	
	public Categories deleteCategory(Long id) {
        Optional<Categories> category = categoryRepo.findById(id);
        if(category.isPresent()) {
        	categoryRepo.deleteById(id);
            return category.get();
        }
        return null;
    }

	
}
