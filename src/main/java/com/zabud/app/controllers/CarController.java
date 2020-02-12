package com.zabud.app.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabud.app.application.CarApplication;
import com.zabud.app.dominio.services.CarService;
import com.zabud.app.infraestructura.mapper.CarMapper;
import com.zabud.app.infraestructura.restdto.CarRestDto;

@RestController
@RequestMapping("/api")
public class CarController {

	private CarApplication carApplication;
	
	
	
	public CarController(@Autowired CarService carService, CarMapper carMapper) {
		// TODO Auto-generated constructor stub
		this.carApplication = new CarApplication(carService, carMapper);
	}
	@PostMapping("/cars")
	public CarRestDto saveCar(@RequestBody CarRestDto car) {
		
		return carApplication.saveCar(car);
	}
	
	@GetMapping("/cars")
	public List<CarRestDto> findAllCar(){
		return carApplication.findAllCar();
	}
	
	@GetMapping("/cars/page/{page}")
	public Page<CarRestDto> findCarPage(@PathVariable Integer page){
		return carApplication.findCarsPage(PageRequest.of(page, 2));
	}
	
	@GetMapping("/cars/{code}")
	public CarRestDto findCarByCode(@PathVariable String code) {
		return carApplication.findCarByCode(code);
	}
	
	@DeleteMapping("/cars/{code}")
	public void deleteCarByCode(@PathVariable String code) {
		 carApplication.deleteCarByCode(code);
	}
	
	@PutMapping("/cars")
	public CarRestDto updateCar(@RequestBody CarRestDto carRestDto) {
		return carApplication.updateCarByCode(carRestDto);
	}
}
