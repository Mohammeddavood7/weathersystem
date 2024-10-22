package com.example.monitoringsystem.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.monitoringsystem.model.WeatherApiResponse;
import com.example.monitoringsystem.model.WeatherData;
import com.example.monitoringsystem.repository.WeatherDataRepository;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

   

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    private final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.alert.temp.threshold}")
    private double alertTempThreshold;

    public WeatherApiResponse getWeatherData(String city) throws Exception {
        String url = API_URL + "?q=" + city + "&appid=" + apiKey;
        try 
        {
        	WeatherApiResponse was = restTemplate.getForObject(url, WeatherApiResponse.class);
        	saveWeatherData(city, was.getMain().getTemp(), was.getMain().getFeels_like(), was.getWeather().get(0).getMain());
            return was;
            
        } catch (HttpClientErrorException e) {
            throw new Exception("City not found");
        }
    }

    public WeatherData saveWeatherData(String city, double temp, double feelsLike, String main) {
        WeatherData data = new WeatherData();
        data.setCity(city);
        data.setTemp(temp);
        data.setFeelsLike(feelsLike);
        data.setMain(main);
        data.setTimestamp(System.currentTimeMillis());
        data.setDate(LocalDate.now());
        return weatherDataRepository.save(data);
    }

    

    
}

