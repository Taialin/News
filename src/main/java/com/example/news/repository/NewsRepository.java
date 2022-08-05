package com.example.news.repository;

import com.example.news.dob.MyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<MyNews, Long> {
}
