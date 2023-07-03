package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.location.Entities.City;
import com.movieticketsystem.location.Entities.Theatre;

public interface CityService {
    
    String addCity(City city);

    String updateCity(String cityName,City city);

    City getCityById(String cityId);

    String deleteCityById(String cityId);

    List<Theatre> getAllTheatres(String cityName);
}
