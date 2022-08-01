package com.example.news.services.impl;

import com.example.news.dob.NewsLinks;
import com.example.news.repository.NewsLinksRepository;
import com.example.news.services.NewsLinksServices;
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
