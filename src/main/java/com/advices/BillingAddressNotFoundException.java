package com.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BillingAddressNotFoundException extends Exception{
	public BillingAddressNotFoundException(String message) {
		super(message);
	}
}
