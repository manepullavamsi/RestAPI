package com.user.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.user.model.Item;
import com.user.service.BusinessService;

@WebMvcTest(DummyController.class)
public class DummyControllerTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BusinessService businessService;

//	@Test
//	public void dummyItem_sucess() throws Exception {
//		RequestBuilder request = MockMvcRequestBuilders.get("/item/get").accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
//				.andExpect(content().json("{itemName:Venkat, itemId:7 ,itemprice:95,quantity:7 }")).andReturn();
//
//	}

	@Test
	public void dummyItemBusiness_sucess() throws Exception {

		when(businessService.getData()).thenReturn(new Item("Venkat", 7, 95,7));

		RequestBuilder request = MockMvcRequestBuilders.get("/item/business").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{itemName:Venkat, itemId:7 ,itemprice:95,quantity:7 }")).andReturn();

	}
	
	@Test
	public void getItems_sucess() throws Exception{
		
		when(businessService.getItems()).thenReturn(Arrays.asList(new Item("Venkat",2,50,7)));
		
		RequestBuilder request=MockMvcRequestBuilders.get("/item/getItems").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockMvc.perform(request)
				.andExpect(content().json("[{itemName:Venkat,itemId:2,itemprice:50,quantity:7}]"))
				.andReturn();
		
	}

}
