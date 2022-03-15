package com.advices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RestaurantNotFoundException.class)
	public ResponseEntity<?> restaurantNotFoundException(RestaurantNotFoundException ex,WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(CustomerNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(BillingAddressNotFoundException.class)
	public ResponseEntity<?> restaurantNotFoundException(BillingAddressNotFoundException ex,WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(FoodItemNotFoundException.class)
	public ResponseEntity<?> foodItemNotFoundException(FoodItemNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(OrderNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<?> loginNotFoundException(LoginNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<?> paymentNotFoundException(PaymentNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
             request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


	
	public ResponseEntity<?> exception(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}

}
