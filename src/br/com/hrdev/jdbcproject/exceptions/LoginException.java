package br.com.hrdev.jdbcproject.exceptions;

public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;
	
	public LoginException(int code){
		super();
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

}
