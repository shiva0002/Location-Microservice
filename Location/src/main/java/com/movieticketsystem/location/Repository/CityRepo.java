package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticketsystem.location.Entities.City;

@Repository
public interface CityRepo extends JpaRepository<City,String>{
    Optional<City> findByCityName(String cityName);
}
