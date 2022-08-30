package com.example.news.services;

import com.example.news.dob.Subscriptions;

import java.util.List;

public interface SubscriptionsServices {

    Subscriptions saves(Subscriptions subscriptions);

    List<Subscriptions> findAll();

    List<Subscriptions> findAllByIds(List<Long> ids);

    Subscriptions findSubById(Long subId);
}
