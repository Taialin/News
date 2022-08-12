package com.example.news.services.impl;

import com.example.news.repository.SubscriptionsRepository;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.userChoiceService;
import org.springframework.beans.factory.annotation.Autowired;

public class userChoiceServiceImpl implements userChoiceService {

    @Autowired
    private UserChoiceRepository repository;
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Override
    public boolean deleteSubscribtion(Long subId) {
        if (repository.findById(subId).isPresent()) {
            repository.deleteById(subId);
            return true;
        }
        return false;
    }


}
