package com.example.news.repository;

import com.example.news.dob.MyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<MyNews, Long> {

    @Query(value = "select cat.news from NewsCategory cat where cat.news_category = :categoryName")
    List<MyNews> findAllByCategoryName(String categoryName);
}
