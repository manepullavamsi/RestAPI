package com.user.utlity;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.user.model.User;

@Component
public class ServiceUtlity {

	public boolean validatePojo(User user)
	{
		Predicate<String> isempty = string -> (string.replaceAll("\\s", "")).length() > 0;
		
		return isempty.test(user.getFirstName())&&isempty.test(user.getLastName())&&isempty.test(user.getPassword())
				&&isempty.test(user.getUserName())&&user.getMobileNumber().signum()>0&&user.getSkills().size()>0;
				
	}
	
	
	
}
