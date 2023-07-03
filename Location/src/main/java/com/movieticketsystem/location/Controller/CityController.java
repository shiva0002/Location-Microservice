package com.movieticketsystem.location.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketsystem.location.Entities.City;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;
    
    @PostMapping("/add")
    public String addCity(City newCity) {
        return cityService.addCity(newCity);
    }

    @PostMapping("/update/{cityName}")
    public String updateCity(@PathVariable String cityName, City city){
        return cityService.updateCity(cityName, city);
    }

    @GetMapping("/getCity/{cityId}")
    public City getCityById(@PathVariable String cityId){
        return cityService.getCityById(cityId);
    }

    @DeleteMapping("/deleteCity/{cityId}")
    public String deleteCityById(@PathVariable String cityId){
        return cityService.deleteCityById(cityId);
    }

    @GetMapping("/getAllThetres/{cityName}")
    public List<Theatre> getAllTheatres(@PathVariable String cityName){
        return cityService.getAllTheatres(cityName);
    }
}
