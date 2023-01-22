package com.jang.ProductsAndCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.ProductsAndCategories.models.Categories;
import com.jang.ProductsAndCategories.models.Products;

@Repository
public interface ProductRepository extends CrudRepository <Products, Long>{
List<Products> findAll();
List<Products> findAllByCategories(Categories categories);
List<Products> findByCategoriesNotContains(Categories categories);
}
