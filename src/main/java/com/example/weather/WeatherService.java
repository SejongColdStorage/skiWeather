package com.example.weather;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public Weather getWeather(String lat, String lon) {
        try {
            JsonNode body = Unirest.get("http://apis.skplanetx.com/weather/current/hourly")
                    .header("Accept", "application/json")
                    .header("Accept-Encoding", "gzip")
                    .header("access_token", "07487df8-7875-420a-a7c3-7a99429bcace")
                    .header("appKey", "055cec7f-c6a0-3480-9bdc-bc543a691935")
                    .queryString("version", 1)
                    .queryString("lat", lat)
                    .queryString("lon", lon)
                    .asJson()
                    .getBody();

            JSONObject weatherJson = body.getObject().getJSONObject("weather").getJSONArray("hourly").getJSONObject(0);

            Weather weather = new Weather();
            weather.setWindSpeed(weatherJson.getJSONObject("wind").getDouble("wspd"));
            weather.setSky(weatherJson.getJSONObject("sky").getString("name"));
            weather.setSkyCode(weatherJson.getJSONObject("sky").getString("code"));

            Temperature temperature = new Temperature();
            JSONObject tempJson = weatherJson.getJSONObject("temperature");

            temperature.setCurrent(tempJson.getDouble("tc"));
            temperature.setMax(tempJson.getDouble("tmax"));
            temperature.setMin(tempJson.getDouble("tmin"));
            weather.setTemperature(temperature);

            return weather;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
