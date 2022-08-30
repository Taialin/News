package com.example.news.services.impl;

import com.example.news.dob.Subscriptions;
import com.example.news.dob.UserChoice;
import com.example.news.repository.*;
import com.example.news.services.PaymentsServices;
import com.example.news.services.UserChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserChoiceServiceImpl implements UserChoiceService {

    @Autowired
    private UserChoiceRepository repository;
    @Autowired
    private SubscriptionsRepository subscriptionsRepository;
    @Autowired
    private BillAccRepository billAccRepository;
    @Autowired
    private PaymentsRepository paymentsRepository;
    @Autowired
    private PaymentsServices paymentsServices;
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public boolean deleteSubscription(Long choiceId) {
        if (repository.findById(choiceId).isPresent()) {
            repository.deleteById(choiceId);
            return true;
        }
        return false;
    }

    @Override
    public void save(UserChoice userChoice) {

        Optional<Subscriptions> subscriptionsOptional = subscriptionsRepository.findById((long) userChoice.getSubId());
        if (subscriptionsOptional.isEmpty()) {
            throw new RuntimeException("There is no such subscription");
        }
        Subscriptions subscription = subscriptionsOptional.get();
        if (subscription.getCost() == null) {
            throw new RuntimeException("There is no price of selected subscription");
        }

        Long billingAccountId = (long) billAccRepository.findBillByUserId((long) userChoice.getUserId());
        paymentsServices.billSubscription(subscription, billingAccountId);
        repository.save(userChoice);
    }

}
