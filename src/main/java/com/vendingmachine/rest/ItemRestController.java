package com.vendingmachine.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.entity.BankStorage;
import com.vendingmachine.entity.Item;
import com.vendingmachine.entity.Money;
import com.vendingmachine.exception.NotFullPaidException;
import com.vendingmachine.exception.SoldOutException;
import com.vendingmachine.service.ItemService;
import com.vendingmachine.service.ItemServiceImpl;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	private ItemService itemService;
	double sum = 0;
	
	@Autowired
	private BankStorage vending;
	
	@Autowired
	public ItemRestController(ItemService theItemService) {
		itemService = theItemService;
	}
	
	@GetMapping("/")
	public String show() {
		return "home";
	}
	
	@GetMapping("/items")
	public List<Item> selectItems() {
		
		return itemService.getItems();
	}
	
	@GetMapping("/items/{itemId}")
	public Item getEmployee(@PathVariable int itemId) {
		
		Item theItem = itemService.selectProduct(itemId);
		
		if (theItem == null) {
			throw new SoldOutException("The item with id " + itemId + " is currently sold out!");
		}
		
		return theItem;
	}
	
	 @PostMapping("/add")
		public String addCash(@RequestBody double value) {
		 
			Money amount = new Money(value);
		    sum += amount.getValue();
			vending.addMoney(amount);
			
			 if (sum == 0) {
				 
				 throw new NotFullPaidException("Insert cash to make a purchase!");
			 }
			 
			 else  return "You inserted = " + sum + " lei";
			 
		} 
	 
	 @DeleteMapping("/items/{itemId}")
		public String deleteItem(@PathVariable int itemId) {
			
			Item tmpItem = itemService.selectProduct(itemId);
			
			if (tmpItem == null) {
				throw new RuntimeException("The item you want to delete does not exist!");
			}
			
			itemService.deleteById(itemId);
			
			return "The item with the id - " + itemId + " has been deleted";
		}
	
}
