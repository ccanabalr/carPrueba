package com.zabud.app.exceptions;

public class ModeloNoValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ModeloNoValidException() {
		super("Modelo no valido");
	}

}
