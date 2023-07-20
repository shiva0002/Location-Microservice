package com.movieticketsystem.location.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticketsystem.location.Entities.Seat;

@Repository
public interface SeatRepo extends JpaRepository<Seat,String>{
    
    Optional<Seat> findBySeatNumber(String seatNumber);
    
}
