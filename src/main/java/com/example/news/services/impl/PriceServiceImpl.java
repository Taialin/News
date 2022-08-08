package com.example.news.services.impl;


import com.example.news.dob.Price;
import com.example.news.repository.PriceRepository;
import com.example.news.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAllById(Long id) {
        return (List<Price>) priceRepository.findAllById(Collections.singleton(id));
    }

}
