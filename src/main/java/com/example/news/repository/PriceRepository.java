package com.example.news.repository;

import com.example.news.dob.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Transactional
    @Modifying
    @Query("update Price c set c.costs = ?1 where c.id = ?2")
    int updateCardBalance(int balance, int id);

}
