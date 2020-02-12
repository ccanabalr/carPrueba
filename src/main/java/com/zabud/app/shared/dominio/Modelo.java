package com.zabud.app.shared.dominio;

import com.zabud.app.exceptions.ModeloNoValidException;

public class Modelo {
	private final String value;

	public String getValue() {
		return value;
	}

	public Modelo(String modelo) {
		this.value = modelo;
		try {
			if(!modelo.matches("[0-9]{4}"))
				throw new ModeloNoValidException();
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new ModeloNoValidException();
		}
		
	}
}
