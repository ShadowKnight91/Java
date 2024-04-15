package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.City;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    @Query(value = "Select * from City where name = :name AND state= :state limit 1", nativeQuery = true)
    Optional<City> findAllByNameAndState(@Param("name") String id1, @Param("state") String id2);

    @Modifying
    @Transactional
    @Query(value = "Delete from Transportation_Mode where name= :name AND state = :state  ", nativeQuery = true)
    void deleteByNameAndState(@Param("name") String id1, @Param("state") String id2);
}
