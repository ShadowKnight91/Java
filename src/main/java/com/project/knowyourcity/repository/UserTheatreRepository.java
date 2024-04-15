package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Theatre;
import com.project.knowyourcity.entity.UserCity;
import com.project.knowyourcity.entity.UserTheatre;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserTheatreRepository extends JpaRepository<UserTheatre, Integer> {
    @Query(value = "Select UT.Id as Id,UT.Theatre_id as Theatre_id, UT.User_id as User_id from User_Theatre UT, Theatre T where User_id = :userId AND T.City_id = :cityId AND T.Theatre_id=UT.Theatre_id", nativeQuery = true)
    List<UserTheatre> findAllByCityId(@Param("userId") Integer id1, @Param("cityId") Integer id2);

    @Query(value = "Select * from User_Theatre where User_id = :userId AND Theatre_Id= :theatreId limit 1", nativeQuery = true)
    Optional<UserTheatre> findAllByUserIdTheatreId(@Param("userId") Integer id1, @Param("theatreId") Integer id2);
    
    @Modifying
    @Transactional
    @Query(value = "Delete from User_Theatre where User_id = :userId AND Theatre_Id= :theatreId", nativeQuery = true)
    void deleteByUserIdTheatreId(@Param("userId") Integer userId, @Param("theatreId") Integer theatreId);
}
