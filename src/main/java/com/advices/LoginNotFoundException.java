package com.advices;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)	
public class LoginNotFoundException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public LoginNotFoundException(String message){
        super(message);
    }

	
}

