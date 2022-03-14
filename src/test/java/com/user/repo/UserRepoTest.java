package com.user.repo;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.user.model.User;

@DataJpaTest
//@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest {

	@Autowired
	private userRepo user;

	@Test
	public void findAll() {
		List<User> ls = user.findAll();
		assertEquals(new BigInteger("9505935287"), ls.get(0).getMobileNumber());
		 
		assertEquals(2,ls.size());
	}

}
