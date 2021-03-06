package com.example.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.forum.ResourceNotFoundException;
import com.example.forum.dao.UserRepository;
import com.example.forum.model.User;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    UserRepository userRepository;
	
	// Get All Users
	@GetMapping("/user/all")
	public List<User> getAllNotes() {
	    return userRepository.findAll();
	}
	
	// Create a new User
	@PostMapping("/user/new")
	public User createUser(@Valid @RequestBody User user) {
	    return userRepository.save(user);
	}
	
	// Get a Single User
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}
	
	// Update a User
	@PutMapping("/user/{id}")
	public User updatedUser(@PathVariable(value = "id") Long userId,
	                                        @Valid @RequestBody User user) {

		User user1 = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    user1.setEmail(user1.getEmail());
	    user1.setUsername(user1.getUsername());

	    User updatedUser = userRepository.save(user1);
	    return updatedUser;
	}
	
	// Delete a User
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
}
