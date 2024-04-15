package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Restaurant;
import com.project.knowyourcity.entity.UserCity;
import com.project.knowyourcity.entity.UserRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;
import java.util.Optional;

public interface UserRestaurantRepository extends JpaRepository<UserRestaurant, Integer> {
    @Query(value = "Select UR.Id as Id,UR.Restaurant_id as Restaurant_id, UR.User_id as User_id from User_Restaurant UR, Restaurant R where User_id = :userId AND R.City_id = :cityId AND R.Restaurant_id = UR.Restaurant_id", nativeQuery = true)
    List<UserRestaurant> findAllByCityId(@Param("userId") Integer id1, @Param("cityId") Integer id2);

    @Query(value = "Select * from User_Restaurant where User_id = :userId AND Restaurant_id= :restaurantId limit 1", nativeQuery = true)
    Optional<UserRestaurant> findAllByUserIdRestId(@Param("userId") Integer id1, @Param("restaurantId") Integer id2);

    @Modifying
    @Transactional
    @Query(value = "Delete from User_Restaurant where User_id = :userId AND Restaurant_id= :restaurantId", nativeQuery = true)
    void deleteByUserIdRestId(@Param("userId") Integer id1, @Param("restaurantId") Integer id2);
}
