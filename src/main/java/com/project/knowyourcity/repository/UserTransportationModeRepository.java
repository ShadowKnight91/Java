package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.TransportationMode;
import com.project.knowyourcity.entity.UserCity;
import com.project.knowyourcity.entity.UserTransportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;
import java.util.Optional;

public interface UserTransportationModeRepository extends JpaRepository<UserTransportation, Integer> {
    @Query(value = "Select * from User_Transportation where User_id = :userId", nativeQuery = true)
    List<UserTransportation> findAllByCityId(@Param("userId") Integer id1);

    @Query(value = "Select * from User_Transportation where User_id = :userId AND Transportation_id= :transId limit 1", nativeQuery = true)
    Optional<UserTransportation> findAllByUserIdTransId(@Param("userId") Integer id1, @Param("transId") Integer id2);

    @Modifying
    @Transactional
    @Query(value = "Delete from User_Transportation where User_id = :userId AND Transportation_id= :transId", nativeQuery = true)
    void deleteByUserIdTransId(@Param("userId") Integer id1, @Param("transId") Integer id2);
}
