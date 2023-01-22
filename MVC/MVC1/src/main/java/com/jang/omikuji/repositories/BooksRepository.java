package com.jang.omikuji.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.omikuji.models.Book;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}
