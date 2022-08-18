package com.example.news.services.impl;

import com.example.news.dob.Subscriptions;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.services.SubscriptionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubImpl implements SubscriptionsServices {
    private final SubscriptionsRepository repository;

    @Autowired
    public SubImpl(SubscriptionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscriptions saves(Subscriptions subscriptions) {
        return repository.save(subscriptions);
    }

    public Subscriptions subscribe(Subscriptions subscriptions) {
        return repository.save(subscriptions);
    }

    @Override
    public List<Subscriptions> findAll() {
        return (List<Subscriptions>) repository.findAll();
    }

    @Override
    public List<Subscriptions> findAllByIds(List<Long> ids) {
        return findAll().stream().filter(id -> ids.contains(id.getId())).collect(Collectors.toList());
    }
    @Override
    public Subscriptions findSubById(Long subId) {
        Optional<Subscriptions> userFromDb = repository.findById(subId);
        return userFromDb.orElse(new Subscriptions());
    }
}

