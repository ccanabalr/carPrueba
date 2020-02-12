package com.zabud.app.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zabud.app.dominio.services.CarService;
import com.zabud.app.exceptions.RegistroNoEncontradoException;
import com.zabud.app.infraestructura.mapper.CarMapper;
import com.zabud.app.infraestructura.restdto.CarRestDto;
import com.zabud.app.shared.dominio.Code;


public class CarApplication {

	private CarService carService;
	
	private CarMapper carMapper;
	
	
	public CarApplication(@Autowired CarService carService, CarMapper carMapper) {
		this.carService = carService;
		this.carMapper = carMapper;
	}
	
	public CarRestDto saveCar(CarRestDto car) {
		car.setCode(UUID.randomUUID().toString());
		return carMapper.apiConverDominioToRestDto(carService.saveCar(carMapper.apiConvertRestDtoToDomimio(car))) ;
	}
	
	public List<CarRestDto> findAllCar(){
		return carMapper.apiConvertListDominioToRestDto(carService.findAllCar());
	}
	
	public Page<CarRestDto> findCarsPage(Pageable pageable){
		return carMapper.apiConvertPageDominioToRestDto(carService.findCarPaginated(pageable));
	}
	
	public CarRestDto findCarByCode(String code) {
		if(carService.findCarByCode(new Code(code)) == null)
			 throw new RegistroNoEncontradoException();
		return carMapper.apiConverDominioToRestDto(carService.findCarByCode(new Code(code)));
	}
	
	public void deleteCarByCode(String code) {
		if(carService.findCarByCode(new Code(code)) == null)
			 throw new RegistroNoEncontradoException();
		carService.deleteCarByCode(new Code(code));
	}
	
	public CarRestDto updateCarByCode(CarRestDto carRestDto) {
		CarRestDto carRestDtoUpdate = carMapper.apiConverDominioToRestDto(carService.findCarByCode(new Code(carRestDto.getCode())));
		carRestDtoUpdate.setMarca(carRestDto.getMarca());
		carRestDtoUpdate.setColor(carRestDto.getColor());
		carRestDtoUpdate.setModelo(carRestDto.getModelo());
		
		return carMapper.apiConverDominioToRestDto(carService.saveCar(carMapper.apiConvertRestDtoToDomimio(carRestDtoUpdate)));
	}
	
}
