package com.example.news.repository;

import com.example.news.dob.NewsLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsLinksRepository extends JpaRepository<NewsLinks, Long> {
}
