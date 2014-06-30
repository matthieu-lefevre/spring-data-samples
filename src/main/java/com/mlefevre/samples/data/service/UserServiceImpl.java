package com.mlefevre.samples.data.service;


import com.mlefevre.samples.data.entity.User;
import com.mlefevre.samples.data.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.create(user);
    }

}
