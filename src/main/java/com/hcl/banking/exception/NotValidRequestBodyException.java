package com.hcl.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotValidRequestBodyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3980529613751793138L;

	public NotValidRequestBodyException(String message) {
		super(message);
	}
}
