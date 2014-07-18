package com.mlefevre.samples.data.repository;

import com.mlefevre.samples.data.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select a from Article a where owner.id = :userId")
    List<Article> findByUser(@Param("userId") Integer userId);
}
