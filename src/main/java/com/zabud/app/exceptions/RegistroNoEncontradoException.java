package com.zabud.app.exceptions;

public class RegistroNoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RegistroNoEncontradoException() {
		// TODO Auto-generated constructor stub
		super("No se encontro registro con el codigo ingresado");
	}

}
