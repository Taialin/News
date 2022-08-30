package com.example.news.services;

import com.example.news.dob.Payments;
import com.example.news.dob.Subscriptions;

import java.util.Date;

public interface PaymentsServices {
    Payments save(Payments payments);

    Date findLastBillDate(Long billingAccountId, int subscriptionId);

    void billSubscription(Subscriptions subscription, Long billingAccountId);
}
