package com.project.knowyourcity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.knowyourcity.dto.HotelDto;
import com.project.knowyourcity.entity.City;
import com.project.knowyourcity.entity.Hotel;
import com.project.knowyourcity.repository.CityRepository;
import com.project.knowyourcity.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.knowyourcity.entity.Hotel;
import com.project.knowyourcity.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private CityRepository cityRepo;
    
    public HotelDto insertNewHotel(HotelDto newHotel) throws Exception{

        Optional<Hotel> temp = hotelRepo.findAllByNameAndAddress(newHotel.getName(),newHotel.getAddress(), newHotel.getCityId());
        if(temp.isPresent()){
            throw new Exception("Hotel already exists");
        }

        City city = City.builder()
                .CityId(newHotel.getCityId())
                .build(); //cityRepo.getReferenceById(newHotel.getCityId());

        Hotel tempHotel = Hotel.builder()
                .city(city)
                .name(newHotel.getName())
                .address(newHotel.getAddress())
                .build();

        Hotel hotel1 = hotelRepo.save(tempHotel);
        return HotelDto.builder()
                .hotelId(hotel1.getHotelId())
                .name(hotel1.getName())
                .address(hotel1.getAddress())
                .cityId(hotel1.getCity().getCityId())
                .build();
    }

    public void deleteHotel(HotelDto hotel) throws Exception{
        Optional<Hotel> temp = hotelRepo.findAllByNameAndAddress(hotel.getName(), hotel.getAddress(),hotel.getCityId());
        if(temp.isEmpty()){
         throw new Exception("No Such Entry");
        }                
        hotelRepo.deleteByNameAndAddress(hotel.getName(), hotel.getAddress(),hotel.getCityId());
     }
}
