package com.project.knowyourcity.service;

import com.project.knowyourcity.dto.TheatreDto;
import com.project.knowyourcity.entity.City;
import com.project.knowyourcity.entity.Theatre;
import com.project.knowyourcity.repository.CityRepository;
import com.project.knowyourcity.repository.TheatreRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepo;
    @Autowired
    private CityRepository cityRepo;
    public TheatreDto insertNewTheatre(TheatreDto newTheatre) throws Exception {

        Optional<Theatre> temp = theatreRepo.findAllByNameAndAddress(newTheatre.getName(),newTheatre.getAddress(),newTheatre.getCityId());
        if(temp.isPresent()){
            throw new Exception("Theatre already exists");
        }
        
        City city = City.builder()
                .CityId(newTheatre.getCityId())
                .build(); //cityRepo.getReferenceById(newTheatre.getCityId());

        Theatre tempTheatre = Theatre.builder()
                .city(city)
                .name(newTheatre.getName())
                .address(newTheatre.getAddress())
                .build();

        Theatre Theatre1 = theatreRepo.save(tempTheatre);

        return TheatreDto.builder()
                .theatreId(Theatre1.getTheatreId())
                .name(Theatre1.getName())
                .address(Theatre1.getAddress())
                .cityId(Theatre1.getCity().getCityId())
                .build();
    }
}
