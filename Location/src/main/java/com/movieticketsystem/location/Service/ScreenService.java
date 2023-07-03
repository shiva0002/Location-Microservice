package com.movieticketsystem.location.Service;

import com.movieticketsystem.location.Entities.Screen;

public interface ScreenService {
    String addScreen(Screen screen);

    String updateScreen(String screenId,Screen screen);

    Screen getScreenById(String screenId);

    String deleteScreenById(String screenId);
}
