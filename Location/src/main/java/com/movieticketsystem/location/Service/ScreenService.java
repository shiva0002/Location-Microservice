package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;

public interface ScreenService {
    String addScreen(Screen screen);

    String updateScreen(String screenId,Screen screen);

    Screen getScreenById(String screenId);

    String deleteScreenById(String screenId);

    List<Seat> getAllAvailableSeats(String screenName);

    String selectSeat(String screenName, List<String> seats);
}
