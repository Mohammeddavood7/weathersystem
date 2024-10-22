package com.example.monitoringsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.monitoringsystem.model.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    List<WeatherData> findByCityAndDate(String city, LocalDate date);
    WeatherData findByCity(String city);

}
