package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.LandmarkDto;
import com.project.knowyourcity.service.LandmarkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This supports all Landmark opertations

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/landmark")
public class LandmarkController {
    @Autowired
    LandmarkService landmarkService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertLandmark(@RequestBody LandmarkDto newLandmark){
        try {
            LandmarkDto retLandmark = landmarkService.insertNewLandmark(newLandmark);
            return new ResponseEntity<>(retLandmark, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Landmark", HttpStatus.BAD_REQUEST);
        }
    }

 
    
}
