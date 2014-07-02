package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
