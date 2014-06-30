package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserRepositoryImpl {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional
    public User create(User user) {
        return this.userRepository.saveAndFlush(user);
    }

}
