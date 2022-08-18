package com.example.news.repository;

import com.example.news.dob.MyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<MyNews, Long> {

    @Query(value = "select distinct n.id, n.title, n.link, n.pubDate, n.creator, n.guid, n.description from news_categories nc inner join news_category cat on cat.id = nc.news_id inner join news n on n.id = nc.category_id\n" +
            "where\n" +
            "n.title like  CONCAT ('%', :categoryName, '%') or cat.news_category like  CONCAT ('%', :categoryName, '%') ", nativeQuery = true)
    List<MyNews> findAllByCategoryName(String categoryName);
}
