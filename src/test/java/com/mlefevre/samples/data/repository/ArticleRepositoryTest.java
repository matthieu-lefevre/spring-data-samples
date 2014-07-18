package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.Article;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-test.xml"})
public class ArticleRepositoryTest extends BaseDataSet {

    @Autowired
    private ArticleRepository articleRepository;

    @Before
    public void init() {
        try {
            addDataSet("ArticleRepositoryTestDataset.xml");
            loadDataSets();

        } catch (SQLException|DatabaseUnitException e) {
            e.printStackTrace();
            fail();
        }
    }

    @After
    public void tearDown() {
        try {
            cleanDataBase();

        } catch (DatabaseUnitException|SQLException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    public void findByUser() {
        List<Article> articles = this.articleRepository.findByUser(1);

        assertNotNull(articles);
        assertEquals(1, articles.size());

        Article article = articles.get(0);
        assertEquals("title1", article.getTitle());
    }

    @Test
    public void findByUser_UserNotFound() {
        List<Article> articles = this.articleRepository.findByUser(5);

        assertNotNull(articles);
        assertTrue(articles.isEmpty());
    }

    @Test
    public void find_Tags() {
        Article article = this.articleRepository.findOne(1);

        assertNotNull(article);

        assertEquals(2, article.getTags().size());
    }


}
