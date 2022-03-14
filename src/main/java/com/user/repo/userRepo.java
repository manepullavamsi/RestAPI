package com.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.model.User;

@Repository
public interface userRepo extends JpaRepository<User, String> {

	// used Named parameter sql injection

	// springboot spring jpa outof box methods

	//Native Query
	@Query(value = "select user_id,user_name,mobile_number,first_name,last_name,Password from user_details where user_name=:user_name", nativeQuery = true)
	User getByusername(@Param("user_name") String username);
	
	//JPQL Query
    @Query(value ="SELECT u FROM User u JOIN FETCH u.skills where u.userName = :user_name")
	Optional<User> findByUserName(@Param("user_name") String userName);
    
    //Spring outof box 
	boolean existsByUserName(String userName);
	
	//Spring outof box 
	@Transactional
	Long deleteByUserName(String username);

}
