package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.model.User;
@Service
public interface userService {
	
	List<User> getAllUsers();
	
	User getUserById(String id);
	
	User saveUser(User u);
	
	User updateUser(User u);
	
	void deleteUser(String id);
	
	
	

}
