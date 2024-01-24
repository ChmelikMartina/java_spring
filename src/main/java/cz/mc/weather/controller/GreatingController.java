package cz.mc.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreatingController {
    @RequestMapping("/hello")
    String hello(){
        return "Hi folks";
    }
    @RequestMapping("/greeting")
    String greeting(){
        return "Hello Spring world";
    }
}
