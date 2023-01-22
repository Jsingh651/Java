package com.jang.omikuji.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jang.omikuji.models.Book;
import com.jang.omikuji.repositories.BooksRepository;

@Service
public class BookService {
	private final BooksRepository booksRepository;
	
	public BookService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	
	public List<Book> allBooks(){
		return booksRepository.findAll();
	}
	
	public Book createBooks(Book b){
		return booksRepository.save(b);
	}
	
	public Book updateBook(Book book) {
		return booksRepository.save(book);
	}
	
    // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = booksRepository.findById(id);
		if(optionalBook.isPresent()) {
			booksRepository.deleteById(id);
		}
	}
	

	public Book findBook(Long id) {
		Optional<Book> optionalBook = booksRepository.findById(id);
		
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		
		else {
			return null;
			 }
		
	}
	
	
}
