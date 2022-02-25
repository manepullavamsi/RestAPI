package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.user.repo.userRepo;
import com.user.service.userService;


@Controller
@RequestMapping("/user")
public class UserController {

	userService user_Service;
	
	@GetMapping
	public List<User> getAllUsers()
	{
		List<User> users=user_Service.getAllUsers();
		return users;
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") String id)
	{
			
		return user_Service.getUserById(id);
		
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user)
	{
		 return user_Service.saveUser(user);
	}
	
	
	@PutMapping
	public User updateUser(@RequestBody User user)
	{
		return user_Service.updateUser(user);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") String id)
	{
		user_Service.deleteUser(id);
	}
	
	
	
	
	
}
