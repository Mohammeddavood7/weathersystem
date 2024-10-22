package com.example.monitoringsystem.model;

import java.util.List;

public class WeatherApiResponse {
    private Main main;
    private List<Weather> weather;
    private long dt;

    // Getters and Setters

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    // Inner classes for Main and Weather

    public static class Main {
        private double temp;
        private double feels_like;

        // Getters and Setters

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(double feels_like) {
            this.feels_like = feels_like; 
        }
    }

    public static class Weather {
        private String main;

        // Getter and Setter

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }
}
