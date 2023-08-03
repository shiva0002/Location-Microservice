package com.movieticketsystem.location.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Service.ScreenService;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @PostMapping("/addScreen")
    public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
        Screen result = screenService.addScreen(screen);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/update/{screenId}")
    public ResponseEntity<Screen> updateScreen(@PathVariable String screenId, @RequestBody Screen screen) {
        Screen result = screenService.updateScreen(screenId, screen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getScreen/{screenId}")
    public ResponseEntity<Screen> getScreenById(@PathVariable String screenId) {
        Screen screen = screenService.getScreenById(screenId);
        return new ResponseEntity<>(screen, HttpStatus.OK);
    }

    @DeleteMapping("/deleteScreen/{screenId}")
    public ResponseEntity<String> deleteScreenById(@PathVariable String screenId) {
        String result = screenService.deleteScreenById(screenId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // @PostMapping("/{screenId}/seats/{seatId}/select")
    // public ResponseEntity<Seat> selectSeat(@PathVariable String screenId, @PathVariable String seatId) {
    //     Seat selectedSeat = screenService.selectSeat(screenId, seatId);
    //     return new ResponseEntity<>(selectedSeat, HttpStatus.OK);
    // }

    @PostMapping("/showSeats/{screenName}")
    public ResponseEntity<List<Seat>> getAllAvailableSeats(@PathVariable String screenName){
        List<Seat> availableSeats = screenService.getAllAvailableSeats(screenName);
        return new ResponseEntity<>(availableSeats,HttpStatus.OK);      
    }

    
}
