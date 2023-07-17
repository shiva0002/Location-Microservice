package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.location.Entities.Seat;

public interface SeatService {

    Seat getSeatById(Long id);

    List<Seat> getAllSeats();

    List<Seat> getAllSeatsByScreenId(Long screenId);

    Seat updateSeat(Long id, Seat seat);

    void deleteSeat(Long id);
    
}
