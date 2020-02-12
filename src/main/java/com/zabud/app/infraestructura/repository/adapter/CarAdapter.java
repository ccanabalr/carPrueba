package com.zabud.app.infraestructura.repository.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zabud.app.dominio.modelo.Car;
import com.zabud.app.dominio.services.CarService;

import com.zabud.app.infraestructura.mapper.CarMapper;
import com.zabud.app.infraestructura.repository.database.CarRepository;
import com.zabud.app.shared.dominio.Code;

@Service
public class CarAdapter implements CarService {

	@Autowired
	private CarMapper carMapper;
	
	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<Car> findAllCar() {
		// TODO Auto-generated method stub
		return carMapper.transformerListDtoToDominio(carRepository.findAll());
	}

	@Override
	public Page<Car> findCarPaginated(Pageable pageable) {
		// TODO Auto-generated method stub
		return carMapper.transformerPageDtoToDominio(carRepository.findAll(pageable));
	}

	@Override
	public Car findCarByCode(Code code) {
		// TODO Auto-generated method stub
		return carMapper.transformerDtoToDominio(carRepository.findById(code.getValue()).orElse(null));
	}

	@Override
	public Car saveCar(Car car) {
		// TODO Auto-generated method stub
		return carMapper.transformerDtoToDominio(carRepository.save(carMapper.transformerDominioToDto(car)));
	}

	@Override
	public void deleteCarByCode(Code code) {
		carRepository.deleteById(code.getValue());
		
	}

}
