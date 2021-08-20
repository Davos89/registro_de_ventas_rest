package com.davos.core.http_errors;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Record Not Found Exception";
	
	public RecordNotFoundException(String detail) {

        super(DESCRIPTION + ". " + detail);
	}

}
