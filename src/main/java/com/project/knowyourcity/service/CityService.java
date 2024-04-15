package com.project.knowyourcity.service;

import com.project.knowyourcity.dto.*;
import com.project.knowyourcity.entity.*;
import com.project.knowyourcity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepo;
    @Autowired
    private RestaurantRepository restRepo;
    @Autowired
    private TheatreRepository theatreRepo;
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private LandmarkRepository landmarkRepo;
    @Autowired
    private TransportationModeRepository transportationModeRepo;

    public List<CityDto> getAllCities() {
        List<City> cityList = cityRepo.findAll();
        List<CityDto> cityDtoList = new ArrayList<>();
        for (City temp : cityList) {
            CityDto city1 = CityDto.builder()
                    .cityId(temp.getCityId())
                    .name(temp.getName())
                    .build();
            cityDtoList.add(city1);
        }
        return cityDtoList;
    }

    public CityDto getCityDetails(Integer cityId) {
        Optional<City> temp = cityRepo.findById(cityId);
        Integer restCount = restRepo.getRestaurantCountInCity(cityId);
        Integer theatreCount = theatreRepo.getTheatreCountInCity(cityId);
        Integer hotelCount = hotelRepo.getHotelCountInCity(cityId);
        Integer landmarkCount = landmarkRepo.getLandmarkCountInCity(cityId);
        Integer transportationModeCount = transportationModeRepo.getTransportationModeCount();

        if (temp.isPresent()) {
            CityDto temp1 = CityDto.builder()
                    .cityId(temp.get().getCityId())
                    .name(temp.get().getName())
                    .state(temp.get().getState())
                    .restaurantCount(restCount)
                    .theatreCount(theatreCount)
                    .hotelCount(hotelCount)
                    .landmarkCount(landmarkCount)
                    .transportationModeCount(transportationModeCount)
                    .build();

            return temp1;
        }
        return null;
    }

    public CityDto getCityData(Integer cityId, String type) {
        Optional<City> city = cityRepo.findById(cityId);
        if (city.isPresent()) {
            City tempCity = city.get();
            List<RestaurantDto> restList = new ArrayList<>();
            if (type.equalsIgnoreCase("All") || type.equalsIgnoreCase("restaurants")) {
                List<Restaurant> tempRestList = restRepo.findRestaurantsByCity(cityId);
                for (Restaurant temp : tempRestList) {
                    RestaurantDto restDto = RestaurantDto.builder()
                            .restaurantId(temp.getRestaurantId())
                            .name(temp.getName())
                            .address(temp.getAddress())
                            .build();
                    restList.add(restDto);
                }
            }

            List<HotelDto> hotelList = new ArrayList<>();
            if (type.equalsIgnoreCase("All") || type.equalsIgnoreCase("hotels")) {
                List<Hotel> tempHotelList = hotelRepo.findHotelsByCity(cityId);
                for (Hotel temp : tempHotelList) {
                    HotelDto hotelDto = HotelDto.builder()
                            .hotelId(temp.getHotelId())
                            .name(temp.getName())
                            .address(temp.getAddress())
                            .build();
                    hotelList.add(hotelDto);
                }
            }

            List<TheatreDto> theatreList = new ArrayList<>();
            if (type.equalsIgnoreCase("All") || type.equalsIgnoreCase("theatres")) {
                List<Theatre> tempTheatreList = theatreRepo.findTheatresByCity(cityId);
                for (Theatre temp : tempTheatreList) {
                    TheatreDto theatreDto = TheatreDto.builder()
                            .theatreId(temp.getTheatreId())
                            .name(temp.getName())
                            .address(temp.getAddress())
                            .build();
                    theatreList.add(theatreDto);
                }
            }

            List<LandmarkDto> landmarkList = new ArrayList<>();
            if (type.equalsIgnoreCase("All") || type.equalsIgnoreCase("landmarks")) {
                List<Landmark> tempLandmarkList = landmarkRepo.findLandmarksByCity(cityId);
                for (Landmark temp : tempLandmarkList) {
                    LandmarkDto landmarkDto = LandmarkDto.builder()
                            .landmarkId(temp.getLandmarkId())
                            .name(temp.getName())
                            .address(temp.getAddress())
                            .build();
                    landmarkList.add(landmarkDto);
                }
            }

            List<TransportationModeDto> transportationModeList = new ArrayList<>();
            if (type.equalsIgnoreCase("All") || type.equalsIgnoreCase("transportation")) {
                List<TransportationMode> tempTransportationModeList = transportationModeRepo.findAll();
                for (TransportationMode temp : tempTransportationModeList) {
                    TransportationModeDto transportationModeDto = TransportationModeDto.builder()
                            .transportationModeId(temp.getTransportationModeId())
                            .mode(temp.getMode())
                            .costLevel(temp.getCostLevel())
                            .build();
                    transportationModeList.add(transportationModeDto);
                }
            }

            CityDto city1 = CityDto.builder()
                    .cityId(tempCity.getCityId())
                    .name(tempCity.getName())
                    .restaurantDtoList(restList)
                    .hotelDtoList(hotelList)
                    .theatreDtoList(theatreList)
                    .landmarkDtoList(landmarkList)
                    .transportationModeDtoList(transportationModeList)
                    .build();
            return city1;
        }
        return null;
    }

    public CityDto insertNewCity(CityDto newCity) throws Exception{

        Optional<City> temp = cityRepo.findAllByNameAndState(newCity.getName(),newCity.getState());
        if(temp.isPresent()){
            throw new Exception("City already exists");
        }

        City city = City.builder()
                .Name(newCity.getName())
                .State(newCity.getState())
                .build(); 

        City city1 = cityRepo.save(city);
        return CityDto.builder()
                .cityId(city1.getCityId())
                .name(city1.getName())
                .state(city1.getState())
                .build();
    }
}

