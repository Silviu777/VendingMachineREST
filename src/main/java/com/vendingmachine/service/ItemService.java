package com.vendingmachine.service;

import java.util.List;

import com.vendingmachine.entity.Item;
import com.vendingmachine.entity.Money;


public interface ItemService {

public List<Item> getItems();
	
	public Item selectProduct(int id);
	
	public Money addMoney(Money cash);
	
	public Item save(Item item);

	public void deleteById(int itemId);
	
}
