package com.movieticketsystem.location.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieticketsystem.location.Entities.Seat;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Long>{

    List<Seat> findByScreenId(Long screenId);
    
}
