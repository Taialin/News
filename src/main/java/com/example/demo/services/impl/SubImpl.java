package com.example.demo.services.impl;

import com.example.demo.dob.Subscriptions;
import com.example.demo.repository.SubscriptionsRepository;
import com.example.demo.services.SubscriptionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubImpl implements SubscriptionsServices {
    private final SubscriptionsRepository repository;

    @Autowired
    public SubImpl(SubscriptionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscriptions save(Subscriptions subscriptions) {
        return repository.save(subscriptions);
    }

    public Subscriptions subscribe(Subscriptions subscriptions) {
        return repository.save(subscriptions);
    }

    @Override
    public List<Subscriptions> findAll() {
        return (List<Subscriptions>) repository.findAll();
    }

/*    @Override
    public boolean existsById(BigInteger id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<Subscriptions> findById(BigInteger id) {
        return repository.findById(id);
    }*/

    @Override
    public void delete(Subscriptions subscriptions) {
        repository.delete(subscriptions);
    }
}
