package com.example.monitoringsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.monitoringsystem.model.WeatherData;

@Service
public class WeatherAlertService {

    @Value("${weather.alert.temp.threshold}")
    private double tempThreshold;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void checkForAlerts(List<WeatherData> latestData) {
        long consecutiveAboveThreshold = latestData.stream()
            .filter(data -> data.getTemp() > tempThreshold)
            .count();

        if (consecutiveAboveThreshold >= 2) {
            triggerAlert(latestData.get(0));
        }
    }

    private void triggerAlert(WeatherData weatherData) {
        // Send an email alert
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo("your_email");
        message.setSubject("Weather Alert: High Temperature Detected");
        message.setText("ALERT: High temperature detected in " + weatherData.getCity() + ".\n" +
                        "Current temperature: " + weatherData.getTemp() + "°C");

        mailSender.send(message);
        
        // Optional console output for testing
        System.out.println("ALERT: High temperature detected in " + weatherData.getCity());
    }
}
