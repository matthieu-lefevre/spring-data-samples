package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.User;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            InputStream stream = this.getFile("UserDataset.xml");

            Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "sa", "");
            IDatabaseConnection dbConnection = new DatabaseConnection(connection);

            InputSource inputSource = new InputSource(stream);
            FlatXmlProducer xmlProducer = new FlatXmlProducer(inputSource);
            IDataSet dataSet = new FlatXmlDataSet(xmlProducer);

            DatabaseOperation.CLEAN_INSERT.execute(dbConnection, dataSet);


        } catch(DataSetException e) {

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
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

}
