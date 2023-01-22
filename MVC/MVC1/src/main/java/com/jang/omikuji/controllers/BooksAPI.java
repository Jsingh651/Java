package com.jang.omikuji.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jang.omikuji.models.Book;
import com.jang.omikuji.services.BookService;

@Controller
public class BooksAPI {
private final BookService bookService;

	public BooksAPI(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> allbook(){
		return bookService.allBooks();
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "form.jsp";
		}
//		Book book = new Book(title, description, language, num_of_pages);
		bookService.createBooks(book); 
		return "redirect:/books";
		
	}
	
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String description, 
    		@RequestParam(value="language") String language, 					
    		@RequestParam(value="num_of_pages") int num_of_pages) 
    {
    	// creating a new book object
        Book book = new Book(id, title, description, language, num_of_pages);
//        book.setId(id);
		Book updatedBook = bookService.updateBook(book);
        return updatedBook;

    }
    
    @RequestMapping(value="/api/delete/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
  
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@GetMapping("/formpage")
	public String formpage(@ModelAttribute("book") Book book) {
		
		return "form.jsp";
	}

}

