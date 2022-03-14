package com.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Arrays;

import java.util.List;

import org.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.user.model.Skills;
import com.user.model.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class UserControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@DisplayName("A special Test Case")
	@Test
	public void deleteByUserNameSucess() {

//		String response = restTemplate.getForObject("/user/deleteByusername/{username}", String.class,
//				"venkat1998@gmail.com");
		ResponseEntity<String> responseEntity = restTemplate.exchange("/user/deleteByusername/{username}",
				HttpMethod.DELETE, null, new ParameterizedTypeReference<String>() {
				}, "Chandana1997@gmail.com");

		String response = responseEntity.getBody();
		assertEquals("1 Chandana1997@gmail.com Deleted from System ", response);

	}

	@Test
	public void deleteByUserNameFailure() {

//		restTemplate.delete("/user/deleteByusername/{username}", "venkat");
		ResponseEntity<String> responseEntity = restTemplate.exchange("/user/deleteByusername/{username}",
				HttpMethod.DELETE, null, new ParameterizedTypeReference<String>() {
				}, "Venkat");

		assertEquals("Please Ensure username is correct or the details of this username dosen't exist in our System ",
				responseEntity.getBody());

	}

	@Test
	public void saveUserSucess() {
		User postUser = new User(44, Arrays.asList(new Skills("Java", 45, "Chandana1997@gmail.com")),
				"Chandana1997@gmail.com", new BigInteger("7671972483"), "Venkat", "Srinvas", "Venkat@1374");
		HttpEntity<User> requestEntity = new HttpEntity<>(postUser);

//		ResponseEntity<User> user = restTemplate.postForEntity("/user", requestEntity, User.class);
		ResponseEntity<User> responseEntity = restTemplate.exchange("/user", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<User>() {
				});

		assertEquals("Chandana1997@gmail.com", responseEntity.getBody().getUserName());

//		JSONAssert.assertEquals("{userid: 44,skills: [{skills_id: 45,userName: Venkat1998@gmail.com,programingLanguage: Java}],userName: Venkat1998@gmail.com,mobileNumber: 7671972483,firstName: Venkat,lastName: Srinvas,password: Venkat@1374 }", user.getBody(), false);
	}

	@Test
	public void saveUserFailure() {
		User postUser = new User(44, Arrays.asList(new Skills("Java", 45, "Venkat1997@gmail.com")),
				"Venkat1997@gmail.com", new BigInteger("7671972483"), "Venkat", "Srinvas", "Venkat@1374");
		HttpEntity<User> requestEntity = new HttpEntity<>(postUser);

		ResponseEntity<String> responseEntity = restTemplate.exchange("/user", HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<String>() {
				});

//		ResponseEntity<String> user = restTemplate.postForEntity("/user", requestEntity, String.class);

		assertEquals("Sorry Already UserName exist in System login with your creditails ", responseEntity.getBody());

//		JSONAssert.assertEquals("{userid: 44,skills: [{skills_id: 45,userName: Venkat1998@gmail.com,programingLanguage: Java}],userName: Venkat1998@gmail.com,mobileNumber: 7671972483,firstName: Venkat,lastName: Srinvas,password: Venkat@1374 }", user.getBody(), false);
	}
	
	@DisplayName("°□°）╯")
	@Test
	public void getAllUsersSucess() throws JSONException {

		ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/user", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		List<User> users = responseEntity.getBody();
//		System.out.println(users);
		assertEquals("Chandana1998@gmail.com", users.get(0).getUserName());
//		String response=restTemplate.getForObject("/user", String.class);
//		System.out.println(response);
//		JSONAssert.assertEquals("[{userid:48}]", response, false);
	}

	@Test
	@DisplayName("😱")
	public void getAllUsersFailure() throws JSONException {
//		String response = restTemplate.getForObject("/user", String.class);
		ResponseEntity<String> responseEntity = restTemplate.exchange("/user", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				});
		assertNotEquals("107", "Please check username UserDoesn't exist", responseEntity.getBody());
	}

	@Test
	public void getByUsernameSucess() {
//		Map<String, String> map = new HashMap<>();
//		map.put("username", "Venkat1998@gmail.com");
		ResponseEntity<User> responseEntity = restTemplate.exchange("/user/getByusername/{username}", HttpMethod.GET,
				null, new ParameterizedTypeReference<User>() {
				}, "Venkat1997@gmail.com");
		User user = responseEntity.getBody();
//		User user = restTemplate.getForObject("/user/getByusername/{username}", User.class, "Venkat1997@gmail.com");

		assertEquals("Venkat1997@gmail.com", user.getUserName());
	}

	@Test
	public void getByUsernameFailure() {
//		Map<String, String> map = new HashMap<>();
//		map.put("username", "Venkat198@gmail.com");
//		String response = restTemplate.getForObject("/user/getByusername/{username}", String.class, "Venkat@fgs");

		ResponseEntity<String> responseEntity = restTemplate.exchange("/user/getByusername/{username}", HttpMethod.GET,
				null, new ParameterizedTypeReference<String>() {
				}, "Venkat@gmail.com");
		assertEquals("Please Ensure username is correct or the details of this username dosen't exist in our System ",
				responseEntity.getBody());
	}

	
	public void updateUserSucess() {
		User postUser = new User(52, Arrays.asList(new Skills("Java", 53, "Venkat1997@gmail.com")),
				"Venkat1997@gmail.com", new BigInteger("7671972483"), "Venkat", "Srinvas", "Venkat@1374");
		HttpEntity<User> requestEntity = new HttpEntity<>(postUser);

		ResponseEntity<User> responseEntity = restTemplate.exchange("/user/", HttpMethod.PUT, requestEntity,
				new ParameterizedTypeReference<User>() {
				});
		assertEquals("Venkat1997@gmail.com", responseEntity.getBody().getUserName());
	}



}
