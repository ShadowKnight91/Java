package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.TransportationModeDto;
import com.project.knowyourcity.service.TransportationModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This supports all Transportation opertations
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Transportation")
public class TransportationModeController {
    @Autowired
    TransportationModeService transportationModeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertTransportationMode(@RequestBody TransportationModeDto newTransportation){
        try {
            TransportationModeDto retTransportation = transportationModeService.insertNewTransportation(newTransportation);
            return new ResponseEntity<>(retTransportation, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Transportation", HttpStatus.BAD_REQUEST);
        }
    }



}
