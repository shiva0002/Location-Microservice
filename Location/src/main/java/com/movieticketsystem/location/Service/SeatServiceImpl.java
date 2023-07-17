package com.movieticketsystem.location.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Exception.NotFoundException;
import com.movieticketsystem.location.Repository.SeatRepo;

public class SeatServiceImpl implements SeatService{

    @Autowired
    private SeatRepo seatRepo;
    
    @Override
    public Seat getSeatById(Long id) {
        return seatRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Seat not found with id: " + id));
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    @Override
    public List<Seat> getAllSeatsByScreenId(Long screenId) {
        return seatRepo.findByScreenId(screenId);
    }

    @Override
    public Seat updateSeat(Long id, Seat seat) {
        Seat existingSeat = getSeatById(id);
        existingSeat.setNumber(seat.getNumber());
        existingSeat.setRow(seat.getRow());
        existingSeat.setAvailable(seat.isAvailable());
        existingSeat.setScreen(seat.getScreen());
        return seatRepo.save(existingSeat);
    }

    @Override
    public void deleteSeat(Long id) {
        Seat seat = getSeatById(id);
        seatRepo.delete(seat);
    }
}
