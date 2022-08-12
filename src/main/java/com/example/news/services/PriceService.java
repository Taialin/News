package com.example.news.services;

import com.example.news.dob.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceService {
    List<Price> findAllById(Long id);

    Price findSubById(Long priceId);
}
