package cz.mc.weather.service;

import cz.mc.weather.City;
import cz.mc.weather.connector.WeatherApiConnector;
import cz.mc.weather.dto.WeatherApiDto;
import cz.mc.weather.dto.WeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
public class WeatherService {
    @RequestMapping("/weather/{city}")
    public WeatherDto getWeatherForCity(City cityEnum) {
        WeatherApiConnector connector = new WeatherApiConnector();
//        return connector.getWeatherForCity(cityEnum);
        WeatherApiDto connectorWeatherForCity = connector.getWeatherForCity(cityEnum);
        WeatherDto weatherDto = transformDto(connectorWeatherForCity);
        return weatherDto;
    }
    private WeatherDto transformDto(WeatherApiDto weatherApiDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setLocation(weatherApiDto.getLocation().getName());
        weatherDto.setWeather_description(weatherApiDto.getCurrent().getCondition().getText());
        weatherDto.setRel_humidity(weatherApiDto.getCurrent().getHumidity());
        weatherDto.setTemp_celsius(weatherApiDto.getCurrent().getTemp_c());
        weatherDto.setWindSpeed_mps(weatherApiDto.getCurrent().getWind_kph()/3.6);
        weatherDto.setWind_direction(weatherApiDto.getCurrent().getWind_dir());
        weatherDto.setTimestamp(weatherApiDto.getCurrent().getLast_updated());
        return weatherDto;
    }
}
