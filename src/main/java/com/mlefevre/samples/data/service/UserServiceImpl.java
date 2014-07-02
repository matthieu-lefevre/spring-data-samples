package com.mlefevre.samples.data.service;

import com.mlefevre.samples.data.entity.User;
import com.mlefevre.samples.data.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.saveAndFlush(user);
    }

    @Override
    public User getUser(Integer id) {
        return this.userRepository.findOne(id);
    }


}
