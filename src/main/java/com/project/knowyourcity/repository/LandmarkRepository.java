package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Landmark;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Integer> {

    @Query(value = "Select * from Landmark where name = :name AND city_id= :cityId and address=:address limit 1", nativeQuery = true)
    Optional<Landmark> findAllByNameAndAddress(@Param("name") String id1, @Param("address") String id2, @Param("cityId") Integer id3);

    @Modifying
    @Transactional
    @Query(value = "Delete from Landmark where name = :name AND city_id= :cityId and address=:address", nativeQuery = true)
    void deleteByNameAndAddress(@Param("name") String id1, @Param("address") String id2, @Param("cityId") Integer id3);
    
    @Query(value = "Select * from Landmark where City_id = :Id", nativeQuery = true)
    List<Landmark> findLandmarksByCity(@Param("Id") Integer id);

    @Query(value = "Select count(*) from Landmark where City_id = :Id", nativeQuery = true)
    Integer getLandmarkCountInCity(@Param("Id") Integer id);
}
