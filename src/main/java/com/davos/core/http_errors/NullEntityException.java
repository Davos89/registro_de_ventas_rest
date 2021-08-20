package com.davos.core.http_errors;

public class NullEntityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String DESCRIPTION = "Null Entity Exception";

    public NullEntityException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
