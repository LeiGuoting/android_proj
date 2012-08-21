package com.fbc.exception;

/**
 * business exception
 * 
 * @author lei.guoting
 *
 */
public class AppException extends RuntimeException {

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;

	//exception code
	private String code;
	
	public AppException() {
		super();
	}
	
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}
	/**
	 * @param code	エラーコード（メッセージID�?
	 * @param message
	 */
	public AppException(String code, String message) {
		super(message);
		this.code = code;
	}
	public String getCode(){
		return code;
	}
}
