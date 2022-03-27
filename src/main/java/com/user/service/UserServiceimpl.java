package com.user.service;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.user.exception.NoData;
import com.user.exception.UserDoesntExists;
import com.user.exception.UserExists;
import com.user.model.User;
import com.user.repo.userRepo;
import com.user.utlity.ServiceUtlity;

@Service("userServiceimpl")
@CacheConfig(cacheNames = { "getUserCache" })
public class UserServiceimpl implements UserService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserServiceimpl.class);

	userRepo userRepo;

	ServiceUtlity serviceutlity;

	UserServiceimpl(userRepo userRepo, ServiceUtlity serviceutlity) {
		Objects.requireNonNull(userRepo);
		Objects.requireNonNull(serviceutlity);
		this.userRepo = userRepo;
		this.serviceutlity = serviceutlity;
	}

	Predicate<String> isempty = string -> (string.replaceAll("\\s", "")).length() <= 0;

	@Override
//	@Cacheable(value = "User")
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		if (users.size() <= 0)
			throw new NoData("107", "Please check username UserDoesn't exist");

		return users;
	}

	@Override
//	@Cacheable(value = "User", key = "#username")
	@Cacheable(keyGenerator = "userKeyGenrator")
	public User getByUsername(String username, String name, HttpServletRequest http,String lastname) {
		LOGGER.info("from Datbase we are getting Data:" + username);
//		LOGGER.error(userRepo.findByUserName(username).toString());
		return userRepo.findByUserName(username)
				.orElseThrow(() -> new UserDoesntExists("107", "Please check username UserDoesn't exist"));

	}

	@Override
	public User saveUser(User user) {

		if (!userRepo.existsByUserName(user.getUserName())) {
			return userRepo.save(user);
		} else {

			throw new UserExists("107", "Please check username UserDoesn't exist");

		}
	}

	@Override
	public User updateUser(User user) {
		if (userRepo.existsByUserName(user.getUserName())) {
			User updateUser = userRepo.getByusername(user.getUserName());
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			updateUser.setMobileNumber(user.getMobileNumber());
			updateUser.setUserName(user.getUserName());
			userRepo.save(updateUser);
			return updateUser;
		} else
			throw new UserDoesntExists("107", "Please check username UserDoesn't exist");

	}

	@Override
//	@CacheEvict(value = "User", key = "#username")
	public Long deleteByUserName(String username) {

		if (userRepo.existsByUserName(username))
			return userRepo.deleteByUserName(username);
		else
			throw new UserDoesntExists("107", "Please check username UserDoesn't exist");

	}

}
