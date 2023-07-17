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
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    
    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<String> addTheatre(@RequestBody Theatre theatre) {
        String result = theatreService.addTheatre(theatre);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{theatreName}")
    public ResponseEntity<String> updateTheatre(@PathVariable String theatreName, @RequestBody Theatre theatre) {
        String result = theatreService.updateTheatre(theatreName, theatre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String theatreId) {
        Theatre theatre = theatreService.getTheatreById(theatreId);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @DeleteMapping("/{theatreId}")
    public ResponseEntity<String> deleteTheatreById(@PathVariable String theatreId) {
        String result = theatreService.deleteTheatreById(theatreId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{theatreName}/screens")
    public ResponseEntity<List<Screen>> getAllScreens(@PathVariable String theatreName) {
        List<Screen> screens = theatreService.getAllScreens(theatreName);
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }
}
