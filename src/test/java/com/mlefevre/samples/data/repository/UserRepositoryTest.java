package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.User;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest extends BaseDataSet {

    @Resource
    private UserRepository userRepository;


    @Before
    public void init() {

        try {
            this.addDataSet("UserDataset.xml");

            this.loadDataSets();

        } catch (DataSetException e) {
            e.printStackTrace();
            fail();
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
            fail();
        }
    }

    @After
    public void tearDown() {
        try {
            this.cleanDataBase();
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
            fail();
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void createTest() {
        User user = new User();
        user.setFirstName("Matthieu");
        user.setLastName("LEFEVRE");

        user = this.userRepository.saveAndFlush(user);

        assertNotNull(user.getId());
    }


    @Test
    public void findOneTest() {
        User u = this.userRepository.findOne(1);
        assertEquals("tilleux", u.getFirstName());

        assertEquals("dev", this.userRepository.findOne(2).getLastName());
    }

    @Test
    public void findAll() {
        List<User> users = this.userRepository.findAll();

        assertEquals(2, users.size());
    }

    @Test
    public void findByLastNameTest() {
        List<User> users = this.userRepository.findByLastName("dev");

        assertEquals(1, users.size());
    }

}
