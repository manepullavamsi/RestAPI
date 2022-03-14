package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.model.Item;
import com.user.repo.ItemRepo;
@Component
public class BusinessService {
	@Autowired
	ItemRepo itemrepo;
	
	public Item getData()
	{
		return new Item("Venkat",7,95,7);
	}
	
	
	public List<Item> getItems()
	{
		return itemrepo.findAll();
	}

}
