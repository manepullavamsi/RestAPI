package com.user.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigInteger;
import java.util.Arrays;




import static org.mockito.Mockito.when;

import com.user.model.Skills;
import com.user.model.User;
import com.user.service.UserService;


@WebMvcTest(UserController.class)

public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

	@MockBean
	UserService userService;

	@Test
	public void getUserSucess() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/user").accept(MediaType.APPLICATION_JSON);

		when(userService.getAllUsers())
				.thenReturn(Arrays.asList(new User(44, Arrays.asList(new Skills("Java", 45, "Venkat1998@gmail.com")),
						"Venkat1998@gmail.com", new BigInteger("7671972483"), "Venkat", "Srinvas", "Venkat@1374")));

		MvcResult result = mockMvc.perform(request).andExpect(content().json(
				"[ {userid: 44,skills: [{skills_id: 45,userName: Venkat1998@gmail.com,programingLanguage: Java}],userName: Venkat1998@gmail.com,mobileNumber: 7671972483,firstName: Venkat,lastName: Srinvas,password: Venkat@1374 }]"))
				.andReturn();

	}

}
