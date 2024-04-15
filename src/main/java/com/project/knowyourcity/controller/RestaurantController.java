package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.RestaurantDto;
import com.project.knowyourcity.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This supports all Restaurant opertations

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertRestaurant(@RequestBody RestaurantDto newRestaurant){
        try {
            RestaurantDto retRestaurant = restaurantService.insertNewRestaurant(newRestaurant);
            return new ResponseEntity<>(retRestaurant, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Restaurant", HttpStatus.BAD_REQUEST);
        }
    }



}
