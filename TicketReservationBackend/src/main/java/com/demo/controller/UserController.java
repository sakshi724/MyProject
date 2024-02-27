package com.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Roles;
import com.demo.entity.User;
import com.demo.entity.UserRoles;
import com.demo.exceptions.UserNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserRepository userRepo;
	@Autowired
	private UserService userService;
	
	@GetMapping("/showUsers")
	public List<User> showUsers() {
		return userRepo.findAll();
	}
    
	@PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(userId, user);
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
	    userService.deleteUser(userId);
	    String message = "User Delete";
	    return ResponseEntity.ok(message);
	}
	

	@PostMapping("/signuP")
	public ResponseEntity<String> signUpUser(@RequestBody User user) throws Exception {
	    user.setProfile("profile.png");

	    Set<UserRoles> roles = new HashSet<>();

	    Roles role = new Roles();
	    role.setRole("normal");

	    UserRoles userRoles = new UserRoles();
	    userRoles.setUser(user);
	    userRoles.setRole(role);

	    roles.add(userRoles);

	    // Save the user and roles
	    User savedUser = this.userService.saveUser(user, roles);

	    // Log or return the message
	    String message = "Register!!";
	    // You can log the message or include it in the response, for example:
	    System.out.println(message);

	    return ResponseEntity.ok("Register successful!!");
	}


	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		User existingUser = userRepo.findByUsername(user.getUsername());
		if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
		}
		return ResponseEntity.ok("Login successful");
	}
}
