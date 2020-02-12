package com.zabud.app.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.zabud.app.dominio.modelo.Car;
import com.zabud.app.infraestructura.dto.CarDto;
import com.zabud.app.infraestructura.restdto.CarRestDto;
import com.zabud.app.shared.dominio.Code;
import com.zabud.app.shared.dominio.Color;
import com.zabud.app.shared.dominio.Marca;
import com.zabud.app.shared.dominio.Modelo;
import com.zabud.app.shared.infraesructura.mapper.MapperApi;
import com.zabud.app.shared.infraesructura.mapper.MapperRepository;

@Component
public class CarMapper implements MapperRepository<CarDto, Car>, MapperApi<CarRestDto, Car> {

	@Override
	public CarDto transformerDominioToDto(Car o) {
		CarDto carDto = new CarDto();
		carDto.setCode(o.getCode().getValue());
		carDto.setMarca(o.getMarca().getValue());
		carDto.setColor(o.getColor().getValue());
		carDto.setModelo(o.getModelo().getValue());
		return carDto;
	}

	@Override
	public Car transformerDtoToDominio(CarDto i) {
		// TODO Auto-generated method stub
		return Car.of(new Code(i.getCode()), new Marca(i.getMarca()), new Color(i.getColor()), new Modelo(i.getModelo()));
	}

	@Override
	public CarRestDto apiConverDominioToRestDto(Car o) {
		// TODO Auto-generated method stub
		return new CarRestDto(o.getCode().getValue(), o.getMarca().getValue(), o.getColor().getValue(), o.getModelo().getValue());
	}

	@Override
	public Car apiConvertRestDtoToDomimio(CarRestDto i) {
		// TODO Auto-generated method stub
		return Car.of(new Code(i.getCode()), new Marca(i.getMarca()), new Color(i.getColor()), new Modelo(i.getModelo()));
	}




}
