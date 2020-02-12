package com.zabud.app.exceptions;

public class CodeNoValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeNoValidException() {
		super("Codigo no valido");
	}
}
