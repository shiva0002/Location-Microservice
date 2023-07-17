package com.movieticketsystem.location.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Exception.NotFoundException;
import com.movieticketsystem.location.Exception.ScreenNotFoundException;
import com.movieticketsystem.location.Exception.SeatNotAvailableException;
import com.movieticketsystem.location.Repository.ScreenRepo;

public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private ScreenRepo screenRepo;

    @Override
    public String addScreen(Screen newScreen) {
        Screen screen = screenRepo.save(newScreen);
        return "Screen Successfully Added...";
    }

    @Override
    public String updateScreen(String screenId, Screen screen) {
        Screen tempScreen = screenRepo.findById(screenId).orElseThrow(()->new ScreenNotFoundException("Screen: "+screenId+" not found"));
        tempScreen.setScreenName(screen.getScreenName());
        tempScreen.setSeats(screen.getSeats());

        Screen newScreen = screenRepo.save(tempScreen);
        return "Screen Details Updated...";
    }

    @Override
    public Screen getScreenById(String screenId) {
        Screen screen = screenRepo.findById(screenId).orElseThrow(()->new ScreenNotFoundException("Screen: "+screenId+" not found"));
        
        return screen;
    }

    @Override
    public String deleteScreenById(String screenId) {
        screenRepo.deleteById(screenId);
        return "Screen Deleted...";
    }

    public Seat selectSeat(Long screenId, Long seatId) {
        Optional<Screen> screenOptional = screenRepo.findByIdAndSeatsId(screenId, seatId);
        Screen screen = screenOptional.orElseThrow(() -> new NotFoundException("Screen or seat not found with provided IDs"));

        List<Seat> seats = screen.getSeats();
        Seat selectedSeat = seats.stream()
                .filter(seat -> seat.getId().equals(seatId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Seat not found with id: " + seatId));

        if (selectedSeat.isAvailable()) {
            selectedSeat.setAvailable(false);
            screenRepo.save(screen);
        } else {
            throw new SeatNotAvailableException("Seat not available");
        }

        return selectedSeat;
    }
    
}
