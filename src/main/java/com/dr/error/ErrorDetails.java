package com.dr.error;

import java.util.Date;

import lombok.Data;

/**
 * error response bean
 * @author rathod
 *
 */
@Data
public class ErrorDetails {
	
	/**
	 * timestamp of error message
	 */
	private Date timestamp;
	
	/**
	 * error message
	 */
    private String message;
    
    /**
     * details of error
     */
    private String details;
    
    /**
     * constructor for initializing attributes
     * @param timestamp
     * @param message
     * @param details
     */
    public ErrorDetails(final Date timestamp, final String message, final String details) {
    	super();
    	this.timestamp = timestamp;
    	this.details = details;
    	this.message = message;
    }
}
