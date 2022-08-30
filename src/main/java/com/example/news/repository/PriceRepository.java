package com.example.news.repository;

import com.example.news.dob.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Transactional
    @Modifying
    @Query("update Price price set price.costs = ?1 where price.id = ?2")
    int updateCardBalance(Integer balance, Long id);

    @Query("SELECT r.costs FROM Price r where r.id = :id")
    int findPriceByById(@Param("id") int id);
}
