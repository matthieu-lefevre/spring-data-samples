package com.mlefevre.samples.data.service;

import com.mlefevre.samples.data.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    User getUser(Integer id);

}
