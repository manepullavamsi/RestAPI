package com.user.unittesting;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import com.user.unittesting.data.BusinessStub;

class Businnesimpl implements BusinessStub{

	@Override
	public int[] getArray() {
		// TODO Auto-generated method stub
		return new int[] {1,4,2};
	}
	
}


class BusinessLogicTests {

	
	
	@Test
	 void testSum() {
		BusinessLogic bus=new BusinessLogic();
		bus.setSomebusiness(new Businnesimpl());
		int result=bus.calculateDataService();
		int expected=7;
		assertEquals(expected, result);
		
	}
	@Test
	void sum_empty() {
		BusinessLogic bus=new BusinessLogic();
		int result=bus.sum(new int[] {});
		int expected=0;
		assertEquals(expected, result);
		
	}
	@Test
	void sum_OneValue() {
		BusinessLogic bus=new BusinessLogic();
		int result=bus.sum(new int[] {7});
		int expected=7;
		assertEquals(expected, result);
		
	}

}
