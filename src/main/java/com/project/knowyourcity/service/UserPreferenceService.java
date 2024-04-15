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
public class UserPreferenceService {
    @Autowired
    private CityRepository cityRepo;
    @Autowired
    private UserTheatreRepository userTheatreRepo;
    @Autowired
    private UserCityRepository userCityRepo;
    @Autowired
    private UserHotelRepository userHotelRepo;
    @Autowired
    private UserRestaurantRepository userRestaurantRepo;
    @Autowired
    private UserLandmarkRepository userLandmarkRepo;
    @Autowired
    private UserTransportationModeRepository userTransportationModeRepo;

    public List<CityDto> getUserCityList(Integer userId){
        List<UserCity> cityList = userCityRepo.findAllByUserId(userId);
        List<CityDto> retList = new ArrayList<>();
        for (UserCity temp : cityList) {
            CityDto tempCity = CityDto.builder()
                    .cityId(temp.getCity().getCityId())
                    .name(temp.getCity().getName())
                    .state(temp.getCity().getState())
                    .build();
            retList.add(tempCity);
        }
        return retList;
    }

    public UserHotelDto insertNewHotel(UserHotelDto newHotel) throws Exception{
        UserHotel tempHotel = UserHotel.builder()
                .userId(newHotel.userId)
                .hotel(Hotel.builder()
                        .hotelId(newHotel.hotelId)
                        .build())
                .build();

        Optional<UserHotel> temp = userHotelRepo.findAllByUserIdHotelId(newHotel.userId,newHotel.hotelId);
        if(temp.isPresent()){
            return UserHotelDto.builder()
                .hotelId(temp.get().getHotel().getHotelId())
                .userId(temp.get().getUserId())
                .id(temp.get().getId())
                .build();
        }       

        UserHotel hotel1 = userHotelRepo.save(tempHotel);
        return UserHotelDto.builder()
                .hotelId(hotel1.getHotel().getHotelId())
                .userId(hotel1.getUserId())
                .id(hotel1.getId())
                .build();
    }

    public UserTheatreDto insertNewTheatre(UserTheatreDto newTheatre) throws Exception{
        UserTheatre tempTheatre = UserTheatre.builder()
                .userId(newTheatre.userId)
                .theatre(Theatre.builder()
                        .theatreId(newTheatre.theatreId)
                        .build())
                .build();

        Optional<UserTheatre> temp = userTheatreRepo.findAllByUserIdTheatreId(newTheatre.userId,newTheatre.theatreId);
        if(temp.isPresent()){
           return UserTheatreDto.builder()
                .theatreId(temp.get().getTheatre().getTheatreId())
                .userId(temp.get().getUserId())
                .id(temp.get().getId())
                .build();
        }       

        UserTheatre theatre1 = userTheatreRepo.save(tempTheatre);
        return UserTheatreDto.builder()
                .theatreId(theatre1.getTheatre().getTheatreId())
                .userId(theatre1.getUserId())
                .id(theatre1.getId())
                .build();
    }

    public UserRestaurantDto insertNewRestaurant(UserRestaurantDto newRestaurant) throws Exception{
        UserRestaurant tempRestaurant = UserRestaurant.builder()
                .userId(newRestaurant.userId)
                .restaurant(Restaurant.builder()
                        .RestaurantId(newRestaurant.restaurantId)
                        .build())
                .build();

        Optional<UserRestaurant> temp = userRestaurantRepo.findAllByUserIdRestId(newRestaurant.userId,newRestaurant.restaurantId);
        if(temp.isPresent()){
            return UserRestaurantDto.builder()
            .restaurantId(temp.get().getRestaurant().getRestaurantId())
            .userId(temp.get().getUserId())
            .id(temp.get().getId())
            .build();
        }                

        UserRestaurant restaurant1 = userRestaurantRepo.save(tempRestaurant);
        return UserRestaurantDto.builder()
                .restaurantId(restaurant1.getRestaurant().getRestaurantId())
                .userId(restaurant1.getUserId())
                .id(restaurant1.getId())
                .build();
    }

    public UserLandmarkDto insertNewLandmark(UserLandmarkDto newLandmark) throws Exception{
        UserLandmark tempLandmark = UserLandmark.builder()
                .userId(newLandmark.userId)
                .landmark(Landmark.builder()
                        .landmarkId(newLandmark.landmarkId)
                        .build())
                .build();

        Optional<UserLandmark> temp = userLandmarkRepo.findAllByUserIdLandmarkId(newLandmark.userId,newLandmark.landmarkId);
        if(temp.isPresent()){
            return UserLandmarkDto.builder()
                .landmarkId(temp.get().getLandmark().getLandmarkId())
                .userId(temp.get().getUserId())
                .id(temp.get().getId())
                .build();
        }       

        UserLandmark landmark1 = userLandmarkRepo.save(tempLandmark);
        return UserLandmarkDto.builder()
                .landmarkId(landmark1.getLandmark().getLandmarkId())
                .userId(landmark1.getUserId())
                .id(landmark1.getId())
                .build();
    }

    public UserTransportationDto insertNewTransportation(UserTransportationDto newTransportation) throws Exception{
        UserTransportation tempTransportation = UserTransportation.builder()
                .userId(newTransportation.userId)
                .transportationMode(TransportationMode.builder()
                        .transportationModeId(newTransportation.getTransportationId())
                        .build())
                .build();

        UserTransportation transportation1 = userTransportationModeRepo.save(tempTransportation);
        return UserTransportationDto.builder()
                .transportationId(transportation1.getTransportationMode().getTransportationModeId())
                .userId(transportation1.getUserId())
                .id(transportation1.getId())
                .build();
    }

    public CityDto getUserCityDetails(Integer userId, Integer cityId) throws Exception{
        Optional<City> tempCity = cityRepo.findById(cityId);
        City temp1 = null;
        if (tempCity.isPresent()){
            temp1 = tempCity.get();
        }
        if (temp1 == null){
            throw new Exception("No City matches the Id");
        }

        List<UserRestaurant> restList = userRestaurantRepo.findAllByCityId(userId,cityId);
        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (UserRestaurant temp : restList) {
            RestaurantDto tempRest = RestaurantDto.builder()
                    .restaurantId(temp.getRestaurant().getRestaurantId())
                    .cityId(temp.getRestaurant().getCity().getCityId())
                    .name(temp.getRestaurant().getName())
                    .address(temp.getRestaurant().getAddress())
                    .build();
            restaurantDtoList.add(tempRest);
        }

        List<UserHotel> hotelList = userHotelRepo.findAllByCityId(userId,cityId);
        List<HotelDto> hotelDtoList = new ArrayList<>();
        for (UserHotel temp : hotelList) {
            HotelDto tempHotel = HotelDto.builder()
                    .hotelId(temp.getHotel().getHotelId())
                    .cityId(temp.getHotel().getCity().getCityId())
                    .name(temp.getHotel().getName())
                    .address(temp.getHotel().getAddress())
                    .build();
            hotelDtoList.add(tempHotel);
        }

        List<UserTheatre> theatreList = userTheatreRepo.findAllByCityId(userId,cityId);
        List<TheatreDto> theatreDtoList = new ArrayList<>();
        for (UserTheatre temp : theatreList) {
                TheatreDto temptheatre = TheatreDto.builder()
                    .theatreId(temp.getTheatre().getTheatreId())
                    .cityId(temp.getTheatre().getCity().getCityId())
                    .name(temp.getTheatre().getName())
                    .address(temp.getTheatre().getAddress())
                    .build();
                theatreDtoList.add(temptheatre);
        }

        List<UserLandmark> landmarkList = userLandmarkRepo.findAllByCityId(userId,cityId);
        List<LandmarkDto> landmarkDtoList = new ArrayList<>();
        for (UserLandmark temp : landmarkList) {
                LandmarkDto tempLandmark = LandmarkDto.builder()
                    .landmarkId(temp.getLandmark().getLandmarkId())
                    .cityId(temp.getLandmark().getCity().getCityId())
                    .name(temp.getLandmark().getName())
                    .address(temp.getLandmark().getAddress())
                    .build();
                landmarkDtoList.add(tempLandmark);
        }

        // List<UserTransportation> transportationList = userTransportationModeRepo.findAllByCityId(userId);
        // List<TransportationModeDto> transportationDtoList = new ArrayList<>();
        // for (UserTransportation temp : transportationList) {
        //         TransportationModeDto tempTransportation = TransportationModeDto.builder()
        //             //.userId(temp.getUserId())
        //             .transportationId(temp.getTransportationMode().getTransportationModeId())
        //             .build();
        //         transportationDtoList.add(tempTransportation);
        // }

        CityDto retCity = CityDto.builder()
                .cityId(cityId)
                .name(temp1.getName())
                .state(temp1.getState())
                .hotelDtoList(hotelDtoList)
                .theatreDtoList(theatreDtoList)
                .landmarkDtoList(landmarkDtoList)
                .restaurantDtoList(restaurantDtoList)
                //.transportationModeDtoList(transportationDtoList)
                .hotelCount(hotelDtoList.size())
                .theatreCount(theatreDtoList.size())
                .restaurantCount(restaurantDtoList.size())
                .landmarkCount(landmarkDtoList.size())
                //.transportationModeCount(transportationDtoList.size())
                .build();

        return retCity;
    }

    public void deleteUserTransportation(Integer userId,Integer transId) throws Exception{
       Optional<UserTransportation> temp = userTransportationModeRepo.findAllByUserIdTransId(userId,transId);
       if(temp.isEmpty()){
        throw new Exception("No Such Entry");
       }                
       userTransportationModeRepo.deleteByUserIdTransId(userId, transId);
    }

    public void deleteUserRestaurant(Integer userId,Integer restId) throws Exception{
        Optional<UserRestaurant> temp = userRestaurantRepo.findAllByUserIdRestId(userId,restId);
        if(temp.isEmpty()){
         throw new Exception("No Such Entry");
        }                
        userRestaurantRepo.deleteByUserIdRestId(userId, restId);
     }

     public void deleteUserTheatre(Integer userId,Integer theatreId) throws Exception{
        Optional<UserTheatre> temp = userTheatreRepo.findAllByUserIdTheatreId(userId,theatreId);
        if(temp.isEmpty()){
         throw new Exception("No Such Entry");
        }                
        userTheatreRepo.deleteByUserIdTheatreId(userId, theatreId);
     }

     public void deleteUserHotel(Integer userId,Integer hotelId) throws Exception{
        Optional<UserHotel> temp = userHotelRepo.findAllByUserIdHotelId(userId,hotelId);
        if(temp.isEmpty()){
         throw new Exception("No Such Entry");
        }                
        userHotelRepo.deleteByUserIdHotelId(userId, hotelId);
     }

     public void deleteUserLandmark(Integer userId,Integer landmarkId) throws Exception{
        Optional<UserLandmark> temp = userLandmarkRepo.findAllByUserIdLandmarkId(userId,landmarkId);
        if(temp.isEmpty()){
         throw new Exception("No Such Entry");
        }                
        userLandmarkRepo.deleteByUserIdLandmarkId(userId, landmarkId);
     }


}

