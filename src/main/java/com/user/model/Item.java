package com.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	String itemName;
	@Id
	int itemId;
	int itemprice;
	int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemprice() {
		return itemprice;
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}
	public Item(String itemName, int itemId, int itemprice,int quantity) {
		super();
		this.itemName = itemName;
		this.itemId = itemId;
		this.itemprice = itemprice;
		this.quantity=quantity;
	}
	public Item() {
		super();
	}
	
	
	
	
	
}
