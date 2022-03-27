package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.user.repo.userRepo;

@SpringBootApplication
//@EnableEurekaClient
@EnableCaching
public class UserApplication {
	@Autowired
	userRepo userRepo;
	
	public static void main(String[] args) {

		SpringApplication.run(UserApplication.class, args);

		
	}

}
