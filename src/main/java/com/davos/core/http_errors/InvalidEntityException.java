package com.davos.core.http_errors;

public class InvalidEntityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DESCRIPTION = "Invalid Entity Exception";

    public InvalidEntityException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
