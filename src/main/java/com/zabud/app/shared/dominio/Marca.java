package com.zabud.app.shared.dominio;

import com.zabud.app.exceptions.MarcaNoValidException;

public class Marca {
	private final String value;

	public String getValue() {
		return value;
	}
	
	public Marca(String marca) {
		this.value = marca;
		
		try {
			if(marca == null || marca.length()<3)
				throw new MarcaNoValidException();
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new MarcaNoValidException();
		}
		
	}
}
