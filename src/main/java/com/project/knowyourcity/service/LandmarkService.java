package com.project.knowyourcity.service;

import com.project.knowyourcity.dto.LandmarkDto;
import com.project.knowyourcity.entity.City;
import com.project.knowyourcity.entity.Landmark;
import com.project.knowyourcity.repository.CityRepository;
import com.project.knowyourcity.repository.LandmarkRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandmarkService {
    @Autowired
    private LandmarkRepository landmarkRepo;
    @Autowired
    private CityRepository cityRepo;
    public LandmarkDto insertNewLandmark(LandmarkDto newLandmark) throws Exception {

        Optional<Landmark> temp = landmarkRepo.findAllByNameAndAddress(newLandmark.getName(),newLandmark.getAddress(),newLandmark.getCityId());
        if(temp.isPresent()){
            throw new Exception("Landmark already exists");
        }
        
        City city = City.builder()
                .CityId(newLandmark.getCityId())
                .build(); //cityRepo.getReferenceById(newLandmark.getCityId());

        Landmark tempLandmark = Landmark.builder()
                .city(city)
                .name(newLandmark.getName())
                .address(newLandmark.getAddress())
                .build();

        Landmark landmark1 = landmarkRepo.save(tempLandmark);

        return LandmarkDto.builder()
                .landmarkId(landmark1.getLandmarkId())
                .name(landmark1.getName())
                .address(landmark1.getAddress())
                .cityId(landmark1.getCity().getCityId())
                .build();
    }
}
