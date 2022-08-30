package com.example.news.repository;

import com.example.news.dob.Subscriptions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionsRepository extends CrudRepository<Subscriptions, Long> {

    List<Subscriptions> findAllById(int subId);
    List<Subscriptions> findAllByCost(String cost);

    @Query("SELECT r.cost FROM Subscriptions r where r.id = :id")
    int findCostById(@Param("id") int id);
}