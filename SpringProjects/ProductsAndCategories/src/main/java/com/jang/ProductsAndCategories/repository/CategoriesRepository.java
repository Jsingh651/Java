package com.jang.ProductsAndCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.ProductsAndCategories.models.Categories;
import com.jang.ProductsAndCategories.models.Products;

@Repository
public interface CategoriesRepository extends CrudRepository <Categories, Long>{
List<Categories> findAll();
List<Categories> findAllByProducts(Products product);
List<Categories> findByProductsNotContains(Products product);


}