package com.example.demo.services;

import com.example.demo.dob.NewsLinks;
import org.springframework.stereotype.Service;

@Service
public interface NewsLinksServices {


    NewsLinks getLink(Long Id);




}
