package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;

import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userServiceimpl")
	UserService userService;

	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		List<User> users=userService.getAllUsers();
		System.out.println("users:"+users);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}

	@GetMapping("/getById/{id}")
	public User getUserById(@PathVariable("id") String id) {
		System.out.println("users:"+id);
		return userService.getUserById(id);

	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping
	public void deleteUser(@RequestBody String id) {
		userService.deleteUser(id);
	}

}
