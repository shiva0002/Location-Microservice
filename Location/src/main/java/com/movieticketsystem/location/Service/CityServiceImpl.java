package com.movieticketsystem.location.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.movieticketsystem.location.Entities.City;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Exception.CityNotFoundException;
import com.movieticketsystem.location.Repository.CityRepo;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;
    
    @Override
    public String addCity(City newCity) {
        
        City city = cityRepo.save(newCity);
        return "City Successfully Added...";
    }

    @Override
    public String updateCity(String cityName, City city) {
        
        City tempCity = cityRepo.findByCityName(cityName).orElseThrow(()->new CityNotFoundException("City: "+cityName+" not found"));
        tempCity.setCityName(city.getCityName());
        tempCity.setCityAddress(city.getCityAddress());

        City newCity = cityRepo.save(tempCity);
        return "City Details Updated...";
    }

    @Override
    public City getCityById(String cityId) {
        City city = cityRepo.findById(cityId).orElseThrow(()-> new CityNotFoundException("City with Id: "+cityId+" not found"));
        
        return city;
    }

    @Override
    public String deleteCityById(String cityId) {
        cityRepo.deleteById(cityId);
        return "City Deleted...";
    }

    @Override
    public List<Theatre> getAllTheatres(String cityName) {
        City city = cityRepo.findByCityName(cityName).orElseThrow(()-> new CityNotFoundException("City with Id: "+cityName+" not found"));

        return city.getTheatre();
    }
    
    
}
