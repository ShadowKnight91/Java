package com.project.knowyourcity.dto;

import com.project.knowyourcity.entity.Hotel;
import com.project.knowyourcity.entity.Restaurant;
import com.project.knowyourcity.entity.Theatre;

import java.util.List;

public class UserPreferenceDto {
    public CityDto cityDto;
    public List<LandmarkDto> landmarkDtoList;
    public List<TheatreDto> theatreDtoList;
    public List<RestaurantDto> restaurantDtoList;
    public List<HotelDto> hotelDtoList;
    public List<TransportationModeDto> transportationModeDtoList;

}
