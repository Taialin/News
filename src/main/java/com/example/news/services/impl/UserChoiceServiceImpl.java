package com.example.news.services.impl;

import com.example.news.dob.UserChoice;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.UserChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserChoiceServiceImpl implements UserChoiceService {

    @Autowired
    private UserChoiceRepository repository;
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    @Override
    public boolean deleteSubscription(Long choiceId) {
        if (repository.findById(choiceId).isPresent()) {
            repository.deleteById(choiceId);
            return true;
        }
        return false;
    }

    @Override
    public boolean save(UserChoice userChoice) {
        repository.save(userChoice);
        return true;
    }

}
