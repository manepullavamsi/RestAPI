package com.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.Item;
import com.user.service.BusinessService;

@RestController
@RequestMapping("/item")
public class DummyController {
	
//	@Autowired
	BusinessService businessService;
	
	DummyController(BusinessService businessService)
	{
		this.businessService=businessService;
	}

	@GetMapping("/get")
	public Item dummyItem()
	{
		return new Item("Venkat",7,95,67);
	}
	
	@GetMapping("/business")
	public Item businessdummyItem()
	{
		return businessService.getData();
	}
	
	@GetMapping("/getItems")
	public ResponseEntity<List<Item>> getItems()
	{
		return ResponseEntity.ok(businessService.getItems());
	}
	
}
