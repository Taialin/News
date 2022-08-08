package com.example.news.repository;

import com.example.news.dob.Subscriptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionsRepository extends CrudRepository<Subscriptions, Long> {

}