package com.example.news.services;

import com.example.news.dob.Subscriptions;
import com.example.news.dob.UserChoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionsServices {

    Subscriptions saves(Subscriptions subscriptions);
    List<Subscriptions> findAll();

    List<Subscriptions> findAllByIds(List<Long> ids);

    Subscriptions findSubById(Long subId);
}
