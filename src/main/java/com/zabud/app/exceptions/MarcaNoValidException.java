package com.zabud.app.exceptions;

public class MarcaNoValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarcaNoValidException() {
		super("Marca no valida");
	}

}
