package com.user.unittesting;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.junit.jupiter.MockitoExtension;

import com.user.unittesting.data.BusinessStub;

@ExtendWith(MockitoExtension.class)
public class BusinessLogicMockTests {
	
	/*
	 * BusinessLogic bus = new BusinessLogic(); BusinessStub businsesMock =
	 * mock(BusinessStub.class);
	 * 
	 * @BeforeEach() public void before() { bus.setSomebusiness(businsesMock);
	 * 
	 * }
	 */
	
	@InjectMocks
	BusinessLogic bus = new BusinessLogic();
	
	@Mock
	BusinessStub businsesMock;
	

	@Test
	void testSum() {

		when(businsesMock.getArray()).thenReturn(new int[] { 1, 2, 3, 1 });
//		bus.setSomebusiness(businsesMock);
		assertEquals(7, bus.calculateDataService());

	}

	@Test
	void sum_empty() {

		when(businsesMock.getArray()).thenReturn(new int[] {});

		assertEquals(0, bus.calculateDataService());

	}

	@Test
	void sum_OneValue() {

		when(businsesMock.getArray()).thenReturn(new int[] { 7 });

		assertEquals(7, bus.calculateDataService());

	}

}
