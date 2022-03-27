package com.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.user.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User getByUsername(String id,String name, HttpServletRequest http,String lastname);
	
	User saveUser(User u);
	
	User updateUser(User u);
	
	Long deleteByUserName(String id);
	
	
	

}
