package com.movieticketsystem.location.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Exception.ScreenNotFoundException;
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
    
}
