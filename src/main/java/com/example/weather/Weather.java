package com.example.weather;

import lombok.Data;

@Data
public class Weather {
    private String sky;
    private String skyCode;
    private Temperature temperature;
    private double windSpeed;
}

