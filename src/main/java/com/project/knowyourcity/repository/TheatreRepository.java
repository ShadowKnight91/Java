package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Theatre;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    @Query(value = "Select * from Theatre where name = :name AND city_id= :cityId and address=:address limit 1", nativeQuery = true)
    Optional<Theatre> findAllByNameAndAddress(@Param("name") String id1, @Param("address") String id2, @Param("cityId") Integer id3);

    @Modifying
    @Transactional
    @Query(value = "Delete from Theatre where name = :name AND city_id= :cityId and address=:address", nativeQuery = true)
    void deleteByNameAndAddress(@Param("name") String id1, @Param("address") String id2, @Param("cityId") Integer id3);
    
    @Query(value = "Select * from Theatre where City_id = :Id", nativeQuery = true)
    List<Theatre> findTheatresByCity(@Param("Id") Integer id);

    @Query(value = "Select count(*) from Theatre where City_id = :Id", nativeQuery = true)
    Integer getTheatreCountInCity(@Param("Id") Integer id);
}
