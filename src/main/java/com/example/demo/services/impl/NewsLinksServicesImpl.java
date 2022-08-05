package com.example.demo.services.impl;

import com.example.demo.dob.NewsLinks;
import com.example.demo.repository.NewsLinksRepository;
import com.example.demo.services.NewsLinksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsLinksServicesImpl implements NewsLinksServices {

    @Autowired
    NewsLinksRepository newsLinksRepository;

    @Override
    public NewsLinks getLink(Long Id) {
        return newsLinksRepository.getOne(2L);
    }

}
