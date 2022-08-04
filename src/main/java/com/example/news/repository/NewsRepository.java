package com.example.news.repository;

import com.example.news.dob.MyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<MyNews, Long> {

    @Query ("SELECT p FROM MyNews p WHERE " +
            " CONCAT(p.title, p.category) "
            + "LIKE %?1%"
    )
    List<MyNews> findAll(String keyword);
}
