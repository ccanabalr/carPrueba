package com.zabud.app.shared.dominio;

import com.zabud.app.exceptions.CodeNoValidException;

public class Code {
	private final String value;

	public String getValue() {
		return value;
	}
	
	public Code(String code) {
		this.value = code;
		
		try {
			if(code == null)
				throw new CodeNoValidException();
		} catch (NullPointerException e) {
			throw new CodeNoValidException();
		}
		
	}
}
