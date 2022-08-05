package com.example.demo.repository;

import com.example.demo.dob.MyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<MyNews, Long> {
}
