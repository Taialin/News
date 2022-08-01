package com.example.news.services;

import com.example.news.dob.NewsLinks;
import org.springframework.stereotype.Service;

@Service
public interface NewsLinksServices {


    NewsLinks getLink(Long Id);



}
