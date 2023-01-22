package com.jang.ProductsAndCategories.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jang.ProductsAndCategories.models.LoginUser;
import com.jang.ProductsAndCategories.models.User;
import com.jang.ProductsAndCategories.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // This method will be called from the controller
    // whenever a user submits a registration form.
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	} 
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	public User udpateUser(User user) {
		return userRepo.save(user);
	}
	
	
    public User register(User newUser, BindingResult result) {
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	    return null;
    	}
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()){
    		result.rejectValue("email", "Uniuqe", "This email alredy exsits.");
    		return null;
    	}
    	else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return newUser;
    	}
        
    }
    
 
// LOGIN
        public User login(LoginUser newLoginObject, BindingResult result) {
        	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        	
        	if(potentialUser.isPresent() && (BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword()) )) {
        	return potentialUser.get();
        	}
        	result.rejectValue("password", "Matches", "Invalid Password!");
        	return null;

        }
}
