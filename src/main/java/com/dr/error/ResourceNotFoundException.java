package com.dr.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * error handling class
 * @author rathod
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	/**
	 * serialversion constant
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * print error message when invalid resource is requested
	 * @param message
	 */
	public ResourceNotFoundException(final String message) {
		super(message);
	}
	
}
