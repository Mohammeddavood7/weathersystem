



Weather Monitoring System (Spring Boot)
Overview:
A Spring Boot application that retrieves real-time weather data from the OpenWeatherMap API and displays it via a Thymeleaf UI. It includes features like temperature alerts via email, and historical data storage in MySQL.

Features:

Real-time weather data
Thymeleaf UI
Email alerts for temperature thresholds
MySQL database for data storage
Spring Boot and JPA backend
Project Structure:
Main Class:
WeatherMonitoringSystemApplication.java

Entry point for Spring Boot, enables JPA repositories.
Configurations:

AppConfig.java: Configures RestTemplate for API calls.
ThymeleafConfig.java: Sets Thymeleaf as the view resolver.
Controllers:

WeatherController: Handles weather requests and renders data via Thymeleaf.
Models:

WeatherApiResponse.java: Represents API response structure.
WeatherData.java: Entity for weather data storage.
Repositories:

WeatherDataRepository.java: JPA repositor
WeatherService.java: Fetches and saves weather data.
Setup & Run
Prerequisites:

Java 17+, Spring Boot 3.0+, MySQL, Maven, Thymeleaf, OpenWeatherMap API Key.
Steps:

  GIT: 
 https://github.com/https://github.com/Mohammeddavood7/weathersystem

Configure MySQL & API Key in application.properties:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
spring.datasource.username=root
spring.datasource.password=yourpassword
weather.api.key=your-api-key


Access via browser: http://localhost:8080/weather?city=London.
Email Alerts:
Configure alert thresholds & email settings in application.properties:
properties
Copy code
weather.alert.temp.threshold=35
spring.mail.username=your-email@example.com
spring.mail.password=your-password
spring.mail.host=smtp.example.com
Key Endpoints:

GET /weather?city={city_name}: Fetches weather data for the specified city.
Technologies Used:

Spring Boot, Thymeleaf, OpenWeatherMap API, MySQL.
