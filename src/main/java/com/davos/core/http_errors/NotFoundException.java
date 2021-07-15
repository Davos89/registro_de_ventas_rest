package com.davos.core.http_errors;

public class NotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Not Found Exception";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}