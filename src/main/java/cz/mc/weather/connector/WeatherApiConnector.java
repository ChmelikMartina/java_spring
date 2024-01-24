package cz.mc.weather.connector;

import cz.mc.weather.City;
import cz.mc.weather.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=da740959ad9d4a67851100040231312&q=Inverness&aqi=no
    //https://api.weatherapi.com/v1/current.json?key=da740959ad9d4a67851100040231312&q=Oslo&aqi=no
    private static String baseUrl = "https://api.weatherapi.com/v1/";
    private static String urlParameters = "current.json?key=";
    private static String APIKey = "da740959ad9d4a67851100040231312";
    private static String url = baseUrl + urlParameters + APIKey + "&q=";

    public WeatherApiDto getWeatherForCity(City city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        ResponseEntity<WeatherApiDto> responseEntity = template.getForEntity(uri, WeatherApiDto.class);
        return responseEntity.getBody();
    }
}
