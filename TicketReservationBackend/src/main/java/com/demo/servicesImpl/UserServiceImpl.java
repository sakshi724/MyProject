package com.demo.servicesImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.entity.UserRoles;
import com.demo.exceptions.UserNotFoundException;
import com.demo.exceptions.UsernameAlreadyExistsException;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;
import com.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User saveUser(User user, Set<UserRoles> userRoles) throws UsernameAlreadyExistsException {
	    // Check if the user with the same username already exists
	    User existingUser = userRepository.findByUsername(user.getUsername());
	    if (existingUser != null) {
	        System.out.println("User with this username already exists!");
	        throw new UsernameAlreadyExistsException("User with this username already exists!");
	    }

	    // Save roles first
	    for (UserRoles userRole : userRoles) {
	        roleRepository.save(userRole.getRole());
	    }

	    // Set roles for the user
	    user.getUserRole().addAll(userRoles);

	    // Save the user
	    return userRepository.save(user);
	}


	@Override
	public User updateUser(Long userId, User user) {
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());

		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User findByEmail(String email) {
		return null;
	}

}
