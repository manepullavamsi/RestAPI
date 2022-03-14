package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getByUsername(String id);
	
	User saveUser(User u);
	
	User updateUser(User u);
	
	Long deleteByUserName(String id);
	
	
	

}
