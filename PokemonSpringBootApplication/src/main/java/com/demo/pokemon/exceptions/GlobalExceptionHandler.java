package com.demo.pokemon.exceptions;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<Error> handleException(RuntimeException ex) {
		Error error = new Error();
		error.setCode(String.valueOf(HttpStatus.BAD_REQUEST));
		error.setMessage(ex.getMessage());
		error.severity(ErrorSeverity.CRITICAL);
		error.setSource("");
		error.setTarget("");
		error.setInnerErrors(Collections.EMPTY_LIST);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
