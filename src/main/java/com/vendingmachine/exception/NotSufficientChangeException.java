package com.vendingmachine.exception;

public class NotSufficientChangeException extends RuntimeException {

	 public NotSufficientChangeException() {
         super("The machine cannot return your change! We apologise for the inconvenience.");
     }
}
