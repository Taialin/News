package com.example.news.repository;

import com.example.news.dob.Subscriptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionsRepository extends CrudRepository<Subscriptions, Long> {

    List<Subscriptions> findAllById(Long subId);
}