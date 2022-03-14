package com.user.unittesting;

import com.user.unittesting.data.BusinessStub;

public class BusinessLogic {
	
	
	BusinessStub somebusiness;
	
public void setSomebusiness(BusinessStub somebusiness) {
		this.somebusiness = somebusiness;
	}

public int sum (int []a)
{
	int sum=0;
	for(int v:a)
		sum+=v;
	return sum;
}

public int calculateDataService()
{
	
	int a[]=somebusiness.getArray();
	int sum=0;
	for(int v:a)
		sum+=v;
	return sum;
}

}
