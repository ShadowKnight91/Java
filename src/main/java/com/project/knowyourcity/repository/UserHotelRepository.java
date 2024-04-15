package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Hotel;
import com.project.knowyourcity.entity.User;
import com.project.knowyourcity.entity.UserCity;
import com.project.knowyourcity.entity.UserHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;
import java.util.Optional;

public interface UserHotelRepository extends JpaRepository<UserHotel, Integer> {
    @Query(value = "Select UH.Id as Id,UH.Hotel_id as Hotel_id, UH.User_id as User_id from User_Hotel UH, Hotel H where User_id = :userId AND H.City_id = :cityId AND H.Hotel_id=UH.Hotel_id", nativeQuery = true)
    List<UserHotel> findAllByCityId(@Param("userId") Integer id1, @Param("cityId") Integer id2);

    @Query(value = "Select * from User_Hotel where User_id = :userId AND Hotel_id= :hotelId limit 1", nativeQuery = true)
    Optional<UserHotel> findAllByUserIdHotelId(@Param("userId") Integer id1, @Param("hotelId") Integer id2);

    @Modifying
    @Transactional
    @Query(value = "Delete from User_Hotel where User_id = :userId AND Hotel_id= :hotelId", nativeQuery = true)
    void deleteByUserIdHotelId(@Param("userId") Integer id1, @Param("hotelId") Integer id2);
}
