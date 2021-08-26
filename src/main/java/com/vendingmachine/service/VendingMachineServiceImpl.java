package com.vendingmachine.service;

import java.util.TreeMap;

import com.vendingmachine.dao.ItemDAO;
import com.vendingmachine.entity.Money;
public class VendingMachineServiceImpl implements VendingService {

	
	private TreeMap<Money, Integer> moneyMap = new TreeMap<>();

	public TreeMap<Money, Integer> getBills() {
		
		return moneyMap;
	}

	@Override
	public double addMoney(Money cash) {
		
		if (cash.getValue() != 0) {
	           int k = moneyMap.containsKey(cash) ? moneyMap.get(cash) : 0;
			   moneyMap.put(cash, k + 1);
			   
			   return cash.getValue();
			}
			
			else {
				System.out.println("No cash inserted!");
				return 0;
			}
	}	
}
