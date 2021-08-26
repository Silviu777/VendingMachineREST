package com.vendingmachine.dao;

import com.vendingmachine.entity.Item;
import com.vendingmachine.entity.Money;

import java.util.List;

public interface ItemDAO {

	public List<Item> getItems();
	
	public Item selectProduct(int id);

	public void save(Item item);
	
	public void deleteById(int theId);
}
