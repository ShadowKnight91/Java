package com.project.knowyourcity.repository;

import com.project.knowyourcity.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.knowyourcity.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "Select * from User where Email = :email AND Password = :pwd", nativeQuery = true)
    Optional<User> matchUser(@Param("email") String email, @Param("pwd") String password);
}
