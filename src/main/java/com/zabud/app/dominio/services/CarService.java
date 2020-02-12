package com.zabud.app.dominio.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zabud.app.dominio.modelo.Car;
import com.zabud.app.shared.dominio.Code;

public interface CarService {

	public List<Car> findAllCar();
	
	public Page<Car> findCarPaginated(Pageable pageable);
	
	public Car findCarByCode(Code code);
	
	public Car saveCar(Car car);
	
	public void deleteCarByCode(Code code);
}
