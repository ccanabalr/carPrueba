package com.zabud.app.infraestructura.restdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRestDto {

	private String code;
	private String marca;
	private String color;
	private String modelo;
}
