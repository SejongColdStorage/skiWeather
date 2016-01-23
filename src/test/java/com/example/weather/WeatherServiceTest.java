package com.example.weather;

import com.example.SkiWeatherApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SkiWeatherApplication.class)
public class WeatherServiceTest {

    @Autowired
    WeatherService weatherService;

    @Test
    public void testGetWeather() throws Exception {

        System.out.println(
                weatherService.getWeather("37.5652894", "126.8494659")
        );
    }
}