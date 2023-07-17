package com.movieticketsystem.location.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Service.SeatService;

public class SeatController {

    @Autowired
    private SeatService seatService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        Seat seat = seatService.getSeatById(id);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/screens/{screenId}")
    public ResponseEntity<List<Seat>> getAllSeatsByScreenId(@PathVariable Long screenId) {
        List<Seat> seats = seatService.getAllSeatsByScreenId(screenId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        Seat updatedSeat = seatService.updateSeat(id, seat);
        return new ResponseEntity<>(updatedSeat, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return new ResponseEntity<>("Seat deleted successfully", HttpStatus.OK);
    }
}
