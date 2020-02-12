package com.zabud.app.infraestructura.dto;



import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class CarDto extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String marca;
	private String color;
	private String modelo;
	public CarDto(String code, String marca, String color, String modelo) {
		this.setCode(code);
		this.marca = marca;
		this.color = color;
		this.modelo = modelo;
	}
	
	
}
