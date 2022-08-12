package com.example.news.services;

import com.example.news.dob.UserChoice;
import org.springframework.stereotype.Service;

@Service
public interface UserChoiceService {
    boolean deleteSubscription(Long subId);
    boolean save(UserChoice userChoice);
}
