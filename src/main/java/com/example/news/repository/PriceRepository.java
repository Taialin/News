package com.example.news.repository;

import com.example.news.dob.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Modifying
    @Query("update Price u set u.costs = :price where u.id = :id")
    void updateCost(@Param(value = "id") long id, @Param(value = "price") String price);


}
