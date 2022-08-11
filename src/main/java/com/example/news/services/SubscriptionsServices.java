package com.example.news.services;

import com.example.news.dob.Subscriptions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionsServices {

    Subscriptions save(Subscriptions subscriptions);
    List<Subscriptions> findAll();

    List<Subscriptions> findUserById(Long subId);

    List<Subscriptions> findSubUser(Long id);

    boolean unsubscribe(Long subId);


    /*  boolean existsById(BigInteger id);
                      Optional<Subscriptions> findById(BigInteger id);*/
    void delete(Subscriptions subscriptions);
}
