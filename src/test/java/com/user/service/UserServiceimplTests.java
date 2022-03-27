package com.user.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;

import com.user.model.Skills;
import com.user.model.User;
import com.user.repo.userRepo;

//@ExtendWith(MockitoExtension.class)
public class UserServiceimplTests {

	@MockBean
	UserServiceimpl userService;

	@Test
	public void getUserById_sucess() {

//		when(userService.getByUsername("Venkat1997@gmail.com"))
//				.thenReturn(new User(44, Arrays.asList(new Skills("Java", 45, "Venkat1997@gmail.com")),
//						"Venkat1997@gmail.com", new BigInteger("7671972483"), "Venkat", "Srinvas", "Venkat@1374"));

		User user = userService.getByUsername("Venkat1997@gmail.com","Test", new MockHttpServletRequest(),"Hello");
//		System.out.println(userService.getByUsername("Venkat1997@gmail.com"));
		assertNotEquals("Venkat1997@gmail.com", user.getUserName());
	}

}
