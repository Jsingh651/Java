package com.jang.userReg.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.userReg.models.User;

//.. imports .. //

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

 Optional<User> findByEmail(String email);
 
}