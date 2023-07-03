package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticketsystem.location.Entities.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,String>{
    Optional<Theatre> findByTheatreName(String theatreName);
}
