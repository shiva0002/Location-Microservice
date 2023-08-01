package com.movieticketsystem.location.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Exception.TheatreNotFoundException;
import com.movieticketsystem.location.Repository.TheatreRepo;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;

    @Override
    public Theatre addTheatre(Theatre newTheatre) {
        Theatre theatre = theatreRepo.save(newTheatre);
        return theatre;
    }

    @Override
    public Theatre updateTheatre(String theatreName, Theatre theatre) {
        Theatre tempTheatre = theatreRepo.findByTheatreName(theatreName).orElseThrow(()->new TheatreNotFoundException("Theatre: "+theatreName+" not found"));
        tempTheatre.setTheatreName(theatre.getTheatreName());
        tempTheatre.setTheatreAddress(theatre.getTheatreAddress());

        Theatre newTheatre = theatreRepo.save(tempTheatre);
        return newTheatre;
    }

    @Override
    public Theatre getTheatreById(String theatreId) {
        Theatre theatre = theatreRepo.findById(theatreId).orElseThrow(()-> new TheatreNotFoundException("Theatre with Id: "+theatreId+" not found"));
        
        return theatre;
    }

    @Override
    public String deleteTheatreById(String theatreId) {
        theatreRepo.deleteById(theatreId);
        return "Theatre Deleted...";
    }

    @Override
    public List<Screen> getAllScreens(String theatreName) {
        Theatre Theatre = theatreRepo.findByTheatreName(theatreName).orElseThrow(()-> new TheatreNotFoundException("Theatre with Id: "+theatreName+" not found"));

        return Theatre.getScreens();
    }
    
}
