package com.jang.bookClub.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jang.bookClub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

 Optional<User> findByEmail(String email);
 
}
