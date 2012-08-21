package com.fbc.exception;

/**
 * system exception
 * 
 * @author lei.guoting
 */
public class SysException extends RuntimeException {

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;

	public SysException() {
		super();
	}
	public SysException(String message) {
		super(message);
	}

	public SysException(Throwable cause) {
		super(cause.getMessage(), cause);
	}
	public SysException(String message, Throwable cause) {
		super(message, cause);
	}
}
