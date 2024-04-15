package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.TheatreDto;
import com.project.knowyourcity.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This supports all Theatre opertations

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertTheatre(@RequestBody TheatreDto newTheatre){
        try {
            TheatreDto retTheatre = theatreService.insertNewTheatre(newTheatre);
            return new ResponseEntity<>(retTheatre, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Theatre", HttpStatus.BAD_REQUEST);
        }
    }



}
