package com.example.demo.repository;

import com.example.demo.dob.NewsLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsLinksRepository extends JpaRepository<NewsLinks, Long> {
}
