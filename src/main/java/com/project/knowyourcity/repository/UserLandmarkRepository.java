package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Landmark;
import com.project.knowyourcity.entity.UserCity;
import com.project.knowyourcity.entity.UserLandmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import java.util.List;
import java.util.Optional;

public interface UserLandmarkRepository extends JpaRepository<UserLandmark, Integer> {
    @Query(value = "Select UL.Id as Id,UL.Landmark_id as Landmark_id, UL.User_id as User_id from User_Landmark UL, Landmark L where User_id = :userId AND L.City_id = :cityId AND L.Landmark_id=UL.Landmark_id", nativeQuery = true)
    List<UserLandmark> findAllByCityId(@Param("userId") Integer id1, @Param("cityId") Integer id2);

    @Query(value = "Select * from User_Landmark where User_id = :userId AND Landmark_Id= :landmarkId limit 1", nativeQuery = true)
    Optional<UserLandmark> findAllByUserIdLandmarkId(@Param("userId") Integer id1, @Param("landmarkId") Integer id2);

    @Modifying
    @Transactional
    @Query(value = "Delete from User_Landmark where User_id = :userId AND Landmark_Id= :landmarkId", nativeQuery = true)
    void deleteByUserIdLandmarkId(@Param("userId") Integer id1, @Param("landmarkId") Integer id2);
}
