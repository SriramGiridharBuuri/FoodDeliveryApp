package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FoodItemNotFoundException extends Exception {
	public FoodItemNotFoundException(String message) {
		super(message);
	}
	

	
	
	
}