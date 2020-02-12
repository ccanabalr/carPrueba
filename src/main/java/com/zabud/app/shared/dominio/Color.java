package com.zabud.app.shared.dominio;

import com.zabud.app.exceptions.ColorNoValidException;

public class Color {
	private final String value;

	public String getValue() {
		return value;
	}

	public Color(String color) {
		this.value = color;
		try {
			if(color == null || color.length() <=3)
				throw new ColorNoValidException();
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

	}

}
