package com.zabud.app.infraestructura.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabud.app.infraestructura.dto.CarDto;

public interface CarRepository extends JpaRepository<CarDto, String> {

}
