//package com.example.monitoringsystem.controller;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.monitoringsystem.model.WeatherApiResponse;
//import com.example.monitoringsystem.service.WeatherService;
//
//@Controller
//public class WeatherController 
//{
//
//    @Autowired
//    private WeatherService weatherService;
//
//    @GetMapping("/weather")
//    public String getWeather(@RequestParam String city, Model model) 
//    {
//        try 
//        {
//            WeatherApiResponse response = weatherService.getWeatherData(city);
//            model.addAttribute("city", city);
//            model.addAttribute("temp", String.format("%.2f", response.getMain().getTemp() - 273.15));
//            model.addAttribute("feelsLike", String.format("%.2f", response.getMain().getFeels_like() - 273.15));
//            model.addAttribute("mainCondition", response.getWeather().get(0).getMain());
//
//            // Format timestamp
//            LocalDateTime dateTime = Instant.ofEpochSecond(response.getDt()).atZone(ZoneId.systemDefault()).toLocalDateTime();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            model.addAttribute("timestamp", dateTime.format(formatter));
//
//            return "weather";
//        }
//        catch (Exception e) 
//        {
//            model.addAttribute("error", "Could not retrieve weather data for " + city);
//            return "error"; // Ensure you have an error.html template for displaying errors
//        }
//        
//    }
//    
//    
//}
//
//
//
//
//



package com.example.monitoringsystem.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.monitoringsystem.model.WeatherApiResponse;
import com.example.monitoringsystem.service.WeatherService;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        try {
            WeatherApiResponse response = weatherService.getWeatherData(city);
            model.addAttribute("city", city);
            model.addAttribute("temp", String.format("%.2f", response.getMain().getTemp() - 273.15));
            model.addAttribute("feelsLike", String.format("%.2f", response.getMain().getFeels_like() - 273.15));
            model.addAttribute("mainCondition", response.getWeather().get(0).getMain());

            // Format timestamp
            LocalDateTime dateTime = Instant.ofEpochSecond(response.getDt()).atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            model.addAttribute("timestamp", dateTime.format(formatter));

            return "weather";
        } catch (Exception e) {
            model.addAttribute("error", "Could not retrieve weather data for " + city);
            return "error"; // Ensure you have an error.html template for displaying errors
        }
    }
    
    

   
}
