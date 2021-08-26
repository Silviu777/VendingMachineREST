package com.vendingmachine.entity;


public class Money implements Comparable<Money>{

	private double value;
	
	public Money() {}
	
	public Money(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	@Override
	public int compareTo(Money m) {
		return (int)(this.value - m.getValue());
	}
}
