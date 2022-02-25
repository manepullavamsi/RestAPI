package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repo.userRepo;

@Service("userServiceimpl")
public class UserServiceimpl implements UserService {

	@Autowired
	userRepo userRepo;

	@Override
	public List<User> getAllUsers() {

		List<User> users = userRepo.getAllUsers();
		return users;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return userRepo.getById(id);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		User updatedUser = userRepo.save(u);
		return updatedUser;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);

	}

}
