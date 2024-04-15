package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.TransportationMode;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransportationModeRepository extends JpaRepository<TransportationMode, Integer> {
    @Query(value = "Select count(*) from Transportation_Mode", nativeQuery = true)
    Integer getTransportationModeCount();

    @Query(value = "Select * from Transportation_Mode where cost_level = :costLevel AND mode= :mode limit 1", nativeQuery = true)
    Optional<TransportationMode> findAllByModeAndCost(@Param("mode") String id1, @Param("costLevel") String id2);

    @Modifying
    @Transactional
    @Query(value = "Delete from Transportation_Mode where cost_level = :costLevel AND mode= :mode", nativeQuery = true)
    void deleteByModeAndCost(@Param("mode") String id1, @Param("costLevel") String id2);
}
