package com.example.news.services;

import com.example.news.dob.Subscriptions;

import java.util.List;

public interface SubscriptionsServices {

    Subscriptions save(Subscriptions subscriptions);
    List<Subscriptions> findAll();
    /*  boolean existsById(BigInteger id);
      Optional<Subscriptions> findById(BigInteger id);*/
    void delete(Subscriptions subscriptions);
}
