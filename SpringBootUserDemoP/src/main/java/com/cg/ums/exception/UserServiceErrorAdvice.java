package com.cg.ums.exception;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice //ADVICE CLASS
public class UserServiceErrorAdvice {

	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=Exception.class)
	protected ErrorInfo handleConflicts(Exception e,HttpServletRequest request)
	{
		String bodyOfResponse=e.getMessage();
		String url=request.getRequestURL().toString();
		System.out.println("handleConflict error msg "+ bodyOfResponse+" Req URL "+url);
		
		return new ErrorInfo(url, bodyOfResponse);
		
		
	}
	

	@ExceptionHandler({UserNotFoundException.class,SQLException.class})
	protected ResponseEntity<String> handle2(UserNotFoundException unfexp)
	{
		return handle3(HttpStatus.INTERNAL_SERVER_ERROR,unfexp);
		
		
		
	}
	
	
	protected ResponseEntity<String> handle3(HttpStatus status,UserNotFoundException unfexp)
	{
		return ResponseEntity.status(status).body(unfexp.getMessage());
		
		
		
	}
}
