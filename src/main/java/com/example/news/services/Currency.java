package com.example.news.services;

import org.springframework.stereotype.Service;

@Service
public interface Currency {
    public float convert(String currencyFrom, String currencyTo) throws Exception;
}
