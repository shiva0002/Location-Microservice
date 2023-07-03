package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Theatre;

public interface TheatreService {
    String addTheatre(Theatre theatre);

    String updateTheatre(String theatreName,Theatre theatre);

    Theatre getTheatreById(String theatreId);

    String deleteTheatreById(String theatreId);

    List<Screen> getAllScreens(String theatreName);
}
