package com.example.news.repository;

import com.example.news.dob.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    @Query ("SELECT p FROM News p WHERE " +
            " CONCAT(p.title, p.category) "
            + "LIKE %?1%"
    )
    List<News> findAll(String keyword);
}
