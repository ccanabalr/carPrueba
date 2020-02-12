package com.zabud.app.dominio.modelo;

import com.zabud.app.shared.dominio.Code;
import com.zabud.app.shared.dominio.Color;
import com.zabud.app.shared.dominio.Marca;
import com.zabud.app.shared.dominio.Modelo;

public class Car {

	private Code code;
	private Marca marca;
	private Color color;
	private Modelo modelo;


	
	public static  Car of(Code code, Marca marca, Color color, Modelo modelo) {
		return new Car(code, marca,color,modelo);
	}

	public Car(Code code, Marca marca, Color color, Modelo modelo) {
		this.code = code;
		this.marca = marca;
		this.color = color;
		this.modelo = modelo;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
