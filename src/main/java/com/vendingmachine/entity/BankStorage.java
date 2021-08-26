package com.vendingmachine.entity;

import java.util.Collections;
import java.util.TreeMap;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.vendingmachine.entity.Money;

@Component
public class BankStorage {

	private TreeMap<Money, Integer> moneyMap = new TreeMap<>();

	public TreeMap<Money, Integer> getBills() {
		
		return moneyMap;
	}
	
		
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