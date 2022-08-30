package com.example.news.services.impl;

import com.example.news.dob.Payments;
import com.example.news.dob.Subscriptions;
import com.example.news.repository.BillAccRepository;
import com.example.news.repository.PaymentsRepository;
import com.example.news.services.PaymentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentServicesImpl implements PaymentsServices {

    @Autowired
    private PaymentsRepository paymentsRepository;
    @Autowired
    private BillAccRepository billAccRepository;

    @Override
    public Payments save(Payments payments) {
        return paymentsRepository.save(payments);
    }

    @Override
    public Date findLastBillDate(Long billingAccountId, int subscriptionId) {
        return paymentsRepository.findDateByById(billingAccountId, subscriptionId);
    }

    @Override
    public void billSubscription(Subscriptions subscription, Long billingAccountId) {
        int priceOfSubscription = subscription.getCost().getCosts();
        int billingAccountMoney = (billAccRepository.findMoneyById(billingAccountId));
        if (priceOfSubscription < billingAccountMoney) {
            billAccRepository.updateUserMoney(billingAccountMoney - priceOfSubscription, billingAccountId);
            Payments payments = new Payments();
            Date currentDate = new Date();
            payments.setLastBillTime(currentDate);
            payments.setBillingAccountId(billingAccountId);
            payments.setPriceId(subscription.getCost().getId().intValue());
            payments.setSubscriptionId(subscription.getId().intValue());
            save(payments);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

}
