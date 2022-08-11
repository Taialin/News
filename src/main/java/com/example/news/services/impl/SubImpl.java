package com.example.news.services.impl;

import com.example.news.dob.Subscriptions;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.services.SubscriptionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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


    @Override
    public List<Subscriptions> findUserById(Long subId) {
        List<Subscriptions> userFromDb = repository.findAllById(subId);
        return userFromDb;
    }

    @Override
    public List<Subscriptions> findSubUser(Long id) {
        return findAll().stream().filter(subscriptions -> id.equals(subscriptions.getId())).collect(Collectors.toList());
    }

    @Override
    public boolean unsubscribe(Long subId) {
        if (repository.findById(subId).isPresent()) {
            repository.deleteById(subId);
            return true;
        }
        return false;
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
