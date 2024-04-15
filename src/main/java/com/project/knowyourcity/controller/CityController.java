package com.project.knowyourcity.controller;

import java.util.List;
import com.project.knowyourcity.service.CityService;
import com.project.knowyourcity.dto.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This supports all City opertations

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;
    
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Welcome to Bengaluru",HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<CityDto>> listCities() {
        return new ResponseEntity<>(cityService.getAllCities(),HttpStatus.OK);
    }
    @GetMapping("/details")
    public ResponseEntity<CityDto> listCityDetails(@RequestParam Integer cityId) {
        return new ResponseEntity<>(cityService.getCityDetails(cityId),HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<CityDto> getCityData(@RequestParam Integer cityId, @RequestParam String type) {
        return new ResponseEntity<>(cityService.getCityData(cityId,type),HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertCity(@RequestBody CityDto newCity){
        try {
            CityDto retCity = cityService.insertNewCity(newCity);
            return new ResponseEntity<>(retCity, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error Occurred while inserting City", HttpStatus.BAD_REQUEST);
        }
    }
}
