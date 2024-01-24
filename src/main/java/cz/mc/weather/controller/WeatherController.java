package cz.mc.weather.controller;
import cz.mc.weather.City;
import cz.mc.weather.dto.WeatherDto;
import cz.mc.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@RestController
public class WeatherController {
    @Autowired
    WeatherService service;
    @CrossOrigin
    @RequestMapping("/weather")
//    String getWeather() {
//        return "Pocasi pro vsechna mesta";
//    }
    public Collection<WeatherDto>getWeather(){
        List<WeatherDto> weatherDtoList = new ArrayList<>();
        //WeatherService service = new WeatherService();
        for (City city:City.values()) {
//            WeatherDto weatherDto = service.getWeatherForCity(city);
//            weatherDtoList.add(weatherDto);
           weatherDtoList.add(service.getWeatherForCity(city));
        }
        return weatherDtoList;
    }
    @CrossOrigin
    @RequestMapping("/weather/{city}")
    WeatherDto getWeatherForCity(@PathVariable("city") String city) {
        City cityEnum = City.valueOf(city.toUpperCase());
        //WeatherService service = new WeatherService();
        return service.getWeatherForCity(cityEnum);
    }
}
