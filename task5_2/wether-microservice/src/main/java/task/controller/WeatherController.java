package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import task.model.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    public RestTemplate restTemplate;

    private String apiKey = "8efdb8ac0932204f536f812e5b610977"; //Наверное надо использовать Config server чтоб хранить это

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon) {
        String url = "https://api.openweathermap.org/data/2.5/weather?appid=" + apiKey;
        if(city != null)
            url += "&q=" + city;
        else if(lat != null && lon != null)
            url += "&lat=" + lat + "&lon=" + lon;
        else
            return ResponseEntity.badRequest().body(null);

        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);

        if (weatherResponse == null) {
            return ResponseEntity.status(500).body(null);
        }

        return ResponseEntity.ok(weatherResponse);
    }
}
