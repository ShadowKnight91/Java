package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.HotelDto;
import com.project.knowyourcity.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This supports all Hotel opertations

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertHotel(@RequestBody HotelDto newHotel){
        try {
            HotelDto retHotel = hotelService.insertNewHotel(newHotel);
            return new ResponseEntity<>(retHotel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting hotel", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping()
    public ResponseEntity<Object> deleteHotel(@RequestBody HotelDto hotel){
        try {
            hotelService.deleteHotel(hotel);
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while deleting Hotel", HttpStatus.BAD_REQUEST);
        }
    } 
    
}
