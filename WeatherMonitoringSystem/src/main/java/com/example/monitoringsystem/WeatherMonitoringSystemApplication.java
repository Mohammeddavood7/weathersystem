package com.example.monitoringsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.monitoringsystem.repository")
public class WeatherMonitoringSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherMonitoringSystemApplication.class, args);
    }
}
