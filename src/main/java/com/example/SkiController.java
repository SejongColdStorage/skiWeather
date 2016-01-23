package com.example;

import com.example.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkiController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/weather/current")
    public ResponseEntity getWeather(@RequestParam String lat, @RequestParam String lon) {
        return ResponseEntity.ok(
                weatherService.getWeather(lat, lon)
        );
    }
}
