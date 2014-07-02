package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;


    @Test
    public void createTest() {
        User user = new User();
        user.setFirstName("Matthieu");
        user.setLastName("LEFEVRE");

        user = this.userRepository.saveAndFlush(user);

        assertEquals(1, (int) user.getId());
    }


    @Test
    public void findOneTest() {
        User user = new User();
        user.setFirstName("Matthieu");
        user.setLastName("LEFEBVRE");
        this.userRepository.saveAndFlush(user);

        User u = this.userRepository.findOne(2);
        assertEquals("LEFEBVRE", u.getLastName());
    }

}
