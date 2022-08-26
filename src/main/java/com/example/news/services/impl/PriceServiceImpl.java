package com.example.news.services.impl;


import com.example.news.dob.Price;
import com.example.news.repository.PriceRepository;
import com.example.news.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAllById(Long id) {
        return (List<Price>) priceRepository.findAllById(Collections.singleton(id));
    }
    @Override
    public Price findSubById(Long priceId) {
        Optional<Price> userFromDb = priceRepository.findById(priceId);
        return userFromDb.orElse(new Price());
    }

  /*  public void updateSubCost(long id, String cost) {
        priceRepository.updateCost(id, cost);
    }*/


}
