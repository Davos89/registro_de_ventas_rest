package com.davos.core.http_errors;

public class AccessDeniedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Access Denied Exception";

    public AccessDeniedException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
