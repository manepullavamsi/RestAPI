package com.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api(value = "This Rest Api is used for curd operations")
//@EnableCaching
public class UserController {

	UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "This is Get Rest end point in order to get all users which are exist in system.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "This code represents user Details fetched sucessfully "),
			@ApiResponse(code = 400, message = "This code is represnt user Details don't have System is empty.") })
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();

		return ResponseEntity.ok(users);// bulider pattern ResponseEntity.ok(users)

	}

	@ApiOperation(value = "This is Getby Id  Rest end point in order to get particular user based on username ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "This code represents user Details fetched sucessfully "),
			@ApiResponse(code = 400, message = "This code is represnt user Details don't have because provided username is not exist in System") })

	@GetMapping("/getByusername/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable("username") @Email String username,HttpServletRequest http) {

		return ResponseEntity.ok(userService.getByUsername(username,username.substring(0, 3),http,"Testing"));

	}

	@ApiOperation(value = "This is Post  Rest end point in order to save particular user with entity model ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "This code represents user Details fetched sucessfully "),
			@ApiResponse(code = 404, message = "This code is represnt username already exist in system ") })
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "This is put update Rest end point in order to update particular user based on username ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "This code represents user Details fetched sucessfully "),
			@ApiResponse(code = 400, message = "This code is represnt user Details don't have because provided username is not exist in System") })
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}

	@ApiOperation(value = "This is Delete  Rest end point in order to delete particular user based on username from system")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "This code represents user Details fetched sucessfully "),
			@ApiResponse(code = 400, message = "This code is represnt user Details don't have because provided username is not exist in System") })
	@DeleteMapping("/deleteByusername/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable("username") @Email String username) {
		return new ResponseEntity<String>(
				userService.deleteByUserName(username).toString() + " " + username + " Deleted from System ",
				HttpStatus.OK);
	}

}
