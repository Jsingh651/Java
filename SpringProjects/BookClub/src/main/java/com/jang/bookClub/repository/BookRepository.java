package com.jang.bookClub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.bookClub.models.Books;


@Repository
public interface BookRepository extends CrudRepository <Books, Long>{
	List<Books> findAll();

}
