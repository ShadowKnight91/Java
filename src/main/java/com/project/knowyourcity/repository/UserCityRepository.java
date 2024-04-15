package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.City;
import com.project.knowyourcity.entity.Hotel;
import com.project.knowyourcity.entity.UserCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCityRepository extends JpaRepository<UserCity, Integer> {
    @Query(value = "Select * from User_City where User_id = :userId ORDER BY Id DESC", nativeQuery = true)
    List<UserCity> findAllByUserId(@Param("userId") Integer id);
}
