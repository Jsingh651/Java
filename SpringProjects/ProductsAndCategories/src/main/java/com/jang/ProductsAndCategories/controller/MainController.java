package com.jang.ProductsAndCategories.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.ProductsAndCategories.models.Categories;
import com.jang.ProductsAndCategories.models.Products;
import com.jang.ProductsAndCategories.service.CategoryService;
import com.jang.ProductsAndCategories.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
 		model.addAttribute("products", productService.allProducts());
 		model.addAttribute("categories",categoryService.allCategories());
		return "index.jsp";
	}
	
	@GetMapping("/create/products")
	public String productCreate( @ModelAttribute("product") Products product) {
		return "ProductCreate.jsp";
	}
	
	@GetMapping("/create/category")
	public String categoryCreate(@ModelAttribute("category") Categories categories) {
		return "CategoryCreate.jsp";
	}
	
	@PostMapping("/create/route/products")
	public String createProductPost(@Valid @ModelAttribute("product") Products product, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("products", product);
			return "ProductCreate.jsp";
		}
		productService.createProducts(product);
		return "redirect:/";
	}
	
	@PostMapping("/create/route/category")
	public String createProductRoute(@Valid @ModelAttribute("category") Categories categories, BindingResult results, Model model) {
		if (results.hasErrors()) {
			model.addAttribute("categor", categories);
			return "CategoryCreate.jsp";
		}
		categoryService.createCategory(categories);
		return "redirect:/";
	}
	
	@GetMapping("/show/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Products product = productService.findProducts(id);
		model.addAttribute("product", product);
		model.addAttribute("specificCategory", categoryService.specificCategory(product));
		model.addAttribute("nonSpecificCategory", categoryService.nonspecificCategory(product));
		return "productShow.jsp";
	}
	
	@GetMapping("/show/cateogry/{id}")
	public String showCategory(@PathVariable("id")Long id, Model model) {
		Categories category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("specificProduct", productService.specificProduct(category));
		model.addAttribute("nonSpecificProduct", productService.nonspecificProduct(category));
		return "categoryShow.jsp";
	}
	
	@PostMapping("/add/cat/{id}")
	public String addCategorytoProduct(@RequestParam(value = "categoryId") Long categoryId, @PathVariable("id") Long id) {
		Products products = productService.findProducts(id);
		Categories category = categoryService.findCategory(categoryId);
		products.getCategories().add(category);
		productService.updateProducts(products);
		return "redirect:/show/product/" +id;
	}
	
	@PostMapping("/add/product/{id}")// the id is the categories ID
	public String addProductsToCategory(@RequestParam(value="productId") Long productId, @PathVariable("id") Long id) {
		Products products = productService.findProducts(productId);
		Categories category = categoryService.findCategory(id);
		category.getProducts().add(products);
		categoryService.updateCategory(category);
		return "redirect/show/category/"+id;
		
	}
	
	
}
