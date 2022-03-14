package com.user.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.exception.NoData;
import com.user.exception.UserDoesntExists;
import com.user.exception.UserExists;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(UserDoesntExists.class)
	public ResponseEntity<?> handleuserDoesntExist(UserDoesntExists userDoesntExists) {
		return new ResponseEntity<String>(
				"Please Ensure username is correct or the details of this username dosen't exist in our System ",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoData.class)
	public ResponseEntity<?> handleNoData(NoData noData) {
		return new ResponseEntity<String>("Best first to register in our System You will be first person",
				HttpStatus.ACCEPTED);
	}

	@ExceptionHandler(UserExists.class)
	public ResponseEntity<?> handleUserExist(UserExists userExist) {
		return new ResponseEntity<String>("Sorry Already UserName exist in System login with your creditails ",
				HttpStatus.ALREADY_REPORTED);
	}

}
