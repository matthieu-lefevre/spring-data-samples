package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where lastName = :lastName")
    List<User> findByLastName(@Param("lastName") String lastName);

}
