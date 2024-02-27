package com.demo.services;

import java.util.Set;

import com.demo.entity.User;
import com.demo.entity.UserRoles;

public interface UserService {
	// Create users
    User saveUser(User user, Set<UserRoles> userRoles) throws Exception;
    
    //update users
    User updateUser(Long userId, User user);
    
    //delete users
    void deleteUser(Long userId);
    
    // Other methods as needed
	User findByEmail(String email);
}
