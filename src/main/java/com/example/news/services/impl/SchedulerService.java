package com.example.news.services.impl;

import com.example.news.dob.Subscriptions;
import com.example.news.dob.UserChoice;
import com.example.news.repository.BillAccRepository;
import com.example.news.repository.PaymentsRepository;
import com.example.news.repository.SubscriptionsRepository;
import com.example.news.repository.UserChoiceRepository;
import com.example.news.services.BillAccServices;
import com.example.news.services.PaymentsServices;
import com.example.news.services.SubscriptionsServices;
import com.example.news.services.UserChoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;

@Service
public class SchedulerService {

    @Autowired
    private PaymentsServices paymentsServices;

    @Autowired
    private UserChoiceRepository userChoiceRepository;

    @Autowired
    private SubscriptionsServices subscriptionsService;

    @Autowired
    private PaymentsServices paymentsService;

    @Autowired
    private BillAccServices billAccService;

    @Autowired
    private UserChoiceService userChoiceService;

//    @Scheduled(initialDelayString = "P1D", fixedDelayString = "P1D")
    @Scheduled(initialDelayString = "3000", fixedDelayString = "3000")
    public void doUpdate() {
        List<UserChoice> userChoices = (List<UserChoice>) userChoiceRepository.findAll();
        Map<Integer, Integer> userIdToBillingAccountId = new HashMap<>();
        for (UserChoice userChoice : userChoices) {
            Subscriptions subscription = subscriptionsService.findSubById((long) userChoice.getSubId());
            if (subscription == null) {
                throw new RuntimeException("subscription was empty");
            }

            int billingAccountId;
            if (!userIdToBillingAccountId.containsKey(userChoice.getUserId())) {
                billingAccountId = billAccService.findBillByUserId((long) userChoice.getUserId());
                userIdToBillingAccountId.put(userChoice.getUserId(), billingAccountId);
            } else {
                billingAccountId = userIdToBillingAccountId.get(userChoice.getUserId());
            }

            Date lastBillDate = paymentsService.findLastBillDate((long) billingAccountId, subscription.getId().intValue());
            if (lastBillDate == null) {
                paymentsServices.billSubscription(subscription, (long) billingAccountId);
                continue;
            }
            LocalDate billDate = LocalDate.ofInstant(lastBillDate.toInstant(),
                    ZoneId.systemDefault()).atStartOfDay().toLocalDate();
            Period period = Period.between(LocalDate.now(), billDate);
            switch (subscription.getCost().getSubForm()) {
                case "day":
                    if (period.getDays() > 1) {
                        paymentsServices.billSubscription(subscription, (long) billingAccountId);
                    }
                    break;
                case "monthly":
                    if (period.getMonths() > 1) {
                        paymentsServices.billSubscription(subscription, (long) billingAccountId);
                    }
                    break;
                case "year":
                    if (period.getYears() > 1) {
                        paymentsServices.billSubscription(subscription, (long) billingAccountId);
                    }
                    break;
            }

        }
    }
}
