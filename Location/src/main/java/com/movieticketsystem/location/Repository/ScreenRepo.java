package com.movieticketsystem.location.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticketsystem.location.Entities.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen,String> {
    
}
