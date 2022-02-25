package com.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.model.User;
@Repository
public interface userRepo extends JpaRepository<User, String>{
	
	@Query(value="select u from user_details u" ,nativeQuery=true)
	List<User> getAllUsers();

}
