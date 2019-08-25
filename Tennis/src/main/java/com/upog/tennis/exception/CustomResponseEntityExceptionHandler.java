package com.upog.tennis.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ExceptionRespone.class)
	public final ResponseEntity<Object> handleExceptionResponse
	(Exception ex, WebRequest request){
		ExceptionRespone exceptionRespone=new ExceptionRespone(new Date(),ex.getMessage(),request.getDescription(false));		
		return new ResponseEntity(exceptionRespone,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
