package com.example.news.services.impl;

import com.example.news.dob.Price;
import com.example.news.dob.User;
import com.example.news.dob.UserChoice;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.repository.UserChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class userChoiceServiceImpl {

    @Autowired
    private UserChoiceRepository repository;
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

/* public Integer addSub (Long subId, User user ){
     subscriptionsRepository.findById(subId);

    }*/

  /*  @Override
    public List<UserChoice> findAll() {
        return (List<UserChoice>) repository.findAll();
    }*/

}
