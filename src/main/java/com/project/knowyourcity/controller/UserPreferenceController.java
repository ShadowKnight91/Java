package com.project.knowyourcity.controller;

import com.project.knowyourcity.dto.*;
import com.project.knowyourcity.service.TheatreService;
import com.project.knowyourcity.service.UserPreferenceService;

import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This supports all User Preference opertations

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/preference")
public class UserPreferenceController {
    @Autowired
    UserPreferenceService userPreferenceService;

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getAllCities(@RequestParam Integer userId) {
        return new ResponseEntity<>(userPreferenceService.getUserCityList(userId),HttpStatus.OK);
    }

    @GetMapping("/cityDetails")
    public ResponseEntity<Object> getCityDetails(@RequestParam Integer userId, @RequestParam Integer cityId) {
        try {
            return new ResponseEntity<>(userPreferenceService.getUserCityDetails(userId,cityId),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/userHotel",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertUserHotel(@RequestBody UserHotelDto newHotel){
        try {
            UserHotelDto retHotel = userPreferenceService.insertNewHotel(newHotel);
            return new ResponseEntity<>(retHotel, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting hotel", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/userfav/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listUserFavs(@RequestParam Integer userId, @RequestParam Integer cityId){
        try {
            CityDto retUserFav = userPreferenceService.getUserCityDetails(userId,cityId);
            return new ResponseEntity<>(retUserFav, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while listing Favs  ", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/userTheatre",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertUserTheatre(@RequestBody UserTheatreDto newTheatre){
        try {
            UserTheatreDto retTheatre = userPreferenceService.insertNewTheatre(newTheatre);
            return new ResponseEntity<>(retTheatre, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Theatre", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/userRestaurant",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertUserRestaurant(@RequestBody UserRestaurantDto newRestaurant){
        try {
            UserRestaurantDto retRestaurant = userPreferenceService.insertNewRestaurant(newRestaurant);
            return new ResponseEntity<>(retRestaurant, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Restaurant", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/userLandmark",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertUserLandmark(@RequestBody UserLandmarkDto newLandmark){
        try {
            UserLandmarkDto retLandmark = userPreferenceService.insertNewLandmark(newLandmark);
            return new ResponseEntity<>(retLandmark, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Landmark", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/userTransportation",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertUserTransportation(@RequestBody UserTransportationDto newTransportation){
        try {
            UserTransportationDto retTransportation = userPreferenceService.insertNewTransportation(newTransportation);
            return new ResponseEntity<>(retTransportation, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting Transportation", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path="/userTransportation/{userId}/{transId}")
    public ResponseEntity<Object> deleteUserTransportation(@NotNull @PathVariable Integer userId, @NotNull @PathVariable Integer transId){
        try {
            userPreferenceService.deleteUserTransportation(userId,transId);
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while deleting Transportation", HttpStatus.BAD_REQUEST);
        }
    } 

    @DeleteMapping("/userRestaurant/{userId}/{restId}")
    public ResponseEntity<Object> deleteUserRestaurant(@PathVariable Integer userId,@PathVariable Integer restId){
        try {
            userPreferenceService.deleteUserRestaurant(userId,restId);
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while deleting Restaurant", HttpStatus.BAD_REQUEST);
        }
    } 

    @DeleteMapping("/userHotel/{userId}/{hotelId}")
    public ResponseEntity<Object> deleteUserHotel(@PathVariable Integer userId, @PathVariable Integer hotelId){
        try {
            userPreferenceService.deleteUserHotel(userId,hotelId);
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while deleting Hotel", HttpStatus.BAD_REQUEST);
        }
    } 

    @DeleteMapping("/userLandmark/{userId}/{landmarkId}")
    public ResponseEntity<Object> deleteUserLandmark(@PathVariable Integer userId, @PathVariable Integer landmarkId){
        try {
            userPreferenceService.deleteUserLandmark(userId,landmarkId);
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while deleting Landmark", HttpStatus.BAD_REQUEST);
        }
    } 

    @DeleteMapping("/userTheatre/{userId}/{theatreId}")
    public ResponseEntity<Object> deleteUserTheatre(@PathVariable Integer userId, @PathVariable Integer theatreId){
        try {
            userPreferenceService.deleteUserTheatre(userId,theatreId);
            return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while deleting Theatre", HttpStatus.BAD_REQUEST);
        }
    } 


}
