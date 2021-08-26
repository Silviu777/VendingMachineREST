package com.vendingmachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vendingmachine.entity.Item;
import com.vendingmachine.entity.Money;
import com.vendingmachine.dao.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	@Transactional
	public List<Item> getItems() {
		
		return itemDAO.getItems();
	}

	@Override
	@Transactional
	public Item selectProduct(int id) {
		
		return itemDAO.selectProduct(id);
	}

	@Override
	public Money addMoney(Money cash) {
		return null;
	}

	@Override
	public Item save(Item item) {
		
		itemDAO.save(item);
		return null;
	}

	@Override
	public void deleteById(int itemId) {
		
		itemDAO.deleteById(itemId);
	}

}
