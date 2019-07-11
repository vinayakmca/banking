package com.hcl.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -2869029429694651422L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
