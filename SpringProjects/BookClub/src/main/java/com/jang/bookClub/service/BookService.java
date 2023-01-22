package com.jang.bookClub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.bookClub.models.Books;
import com.jang.bookClub.repository.BookRepository;

@Service
public class BookService {

	@Autowired
    private BookRepository bookRepo;
	
	public Books findBook(Long id) {
		Optional<Books> optionalBooks = bookRepo.findById(id);
		if(optionalBooks.isPresent()) {
			return optionalBooks.get();
		}else {
			return null;
		}
	}
	
	public List <Books> allBooks (){
		return bookRepo.findAll();
		}
	
	public Books createBook (Books book) {
		return bookRepo.save(book);
	}
	
	public Books updateBook (Books book) {
		return bookRepo.save(book);
	}
	
	
	public Books deleteBook(Long id) {
        Optional<Books> book = bookRepo.findById(id);
        if(book.isPresent()) {
            bookRepo.deleteById(id);
            return book.get();
        }
        return null;
    }

}

