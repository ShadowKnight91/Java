package com.project.knowyourcity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CityDto {
    public Integer cityId;
    public String name;
    public String state;
    public List<RestaurantDto> restaurantDtoList;
    public List<HotelDto> hotelDtoList;
    public List<TheatreDto> theatreDtoList;
    public List<LandmarkDto> landmarkDtoList;
    public List<TransportationModeDto> transportationModeDtoList;
    public Integer restaurantCount;
    public Integer theatreCount;
    public Integer hotelCount;
    public Integer landmarkCount;
    public Integer transportationModeCount;
}