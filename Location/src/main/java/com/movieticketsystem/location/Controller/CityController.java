package com.movieticketsystem.location.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping
    public ResponseEntity<String> addCity(@RequestBody City city) {
        String result = cityService.addCity(city);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{cityName}")
    public ResponseEntity<String> updateCity(@PathVariable String cityName, @RequestBody City city) {
        String result = cityService.updateCity(cityName, city);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<City> getCityByName(@PathVariable String cityName) {
        City city = cityService.getCityByName(cityName);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<String> deleteCityById(@PathVariable String cityId) {
        String result = cityService.deleteCityById(cityId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{cityName}/theatres")
    public ResponseEntity<List<Theatre>> getAllTheatres(@PathVariable String cityName) {
        List<Theatre> theatres = cityService.getAllTheatres(cityName);
        return new ResponseEntity<>(theatres, HttpStatus.OK);
    }
}
