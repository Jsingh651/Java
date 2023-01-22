package com.jang.omikuji.controllers;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jang.omikuji.models.Book;
import com.jang.omikuji.services.BookService;

@Controller
public class BookController {
    
//@Autowired
//BookService bookService;
	
private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model, @ModelAttribute("book") Book book) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }

	
	@GetMapping("/books/{bookId}")
	public String index (Model model,@PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.print(book);
		model.addAttribute("book", book);
		return "bookshow.jsp";
	}
	
	
	
}
