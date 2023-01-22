package com.jang.ProductsAndCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.ProductsAndCategories.models.Categories;
import com.jang.ProductsAndCategories.models.Products;
import com.jang.ProductsAndCategories.repository.CategoriesRepository;
import com.jang.ProductsAndCategories.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoriesRepository categoryRepstory;
	
	public Products findProducts(Long id) {
		Optional<Products> optionalProducts = productRepository.findById(id);
		if(optionalProducts.isPresent()) {
			return optionalProducts.get();
		}else {
			return null;
		}
	}
	
	public List<Products> specificProduct(Categories c){
		return productRepository.findAllByCategories(c);
	}
	
	public List<Products> nonspecificProduct(Categories c){
		return productRepository.findByCategoriesNotContains(c);
	}
	
	
	
	public List <Products> allProducts (){
		return productRepository.findAll();
		}
	
	public Products createProducts (Products products) {
		return productRepository.save(products);
	}
	
	public Products updateProducts(Products products) {
		return productRepository.save(products);
	}
	
	
	public Products deleteProducts(Long id) {
        Optional<Products> products = productRepository.findById(id);
        if(products.isPresent()) {
        	productRepository.deleteById(id);
            return products.get();
        }
        return null;
    }

}
