package com.example.news.services;

import com.example.news.dob.UserChoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserChoiceService {
    boolean deleteSubscription(Long subId);

    void save(UserChoice userChoice);
}
