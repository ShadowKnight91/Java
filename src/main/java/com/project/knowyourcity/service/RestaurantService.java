package com.project.knowyourcity.service;

import com.project.knowyourcity.dto.RestaurantDto;
import com.project.knowyourcity.entity.City;
import com.project.knowyourcity.entity.Restaurant;
import com.project.knowyourcity.repository.CityRepository;
import com.project.knowyourcity.repository.RestaurantRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepo;
    @Autowired
    private CityRepository cityRepo;
    public RestaurantDto insertNewRestaurant(RestaurantDto newRestaurant) throws Exception{

        Optional<Restaurant> temp = restaurantRepo.findAllByNameAndAddress(newRestaurant.getName(),newRestaurant.getAddress(),newRestaurant.getCityId());
        if(temp.isPresent()){
            throw new Exception("Restaurant already exists");
        }

        City city = City.builder()
                .CityId(newRestaurant.getCityId())
                .build(); //cityRepo.getReferenceById(newRestaurant.getCityId());

        Restaurant tempRestaurant = Restaurant.builder()
                .city(city)
                .name(newRestaurant.getName())
                .address(newRestaurant.getAddress())
                .build();

        Restaurant restaurant1 = restaurantRepo.save(tempRestaurant);

        return RestaurantDto.builder()
                .restaurantId(restaurant1.getRestaurantId())
                .name(restaurant1.getName())
                .address(restaurant1.getAddress())
                .cityId(restaurant1.getCity().getCityId())
                .build();
    }
}
