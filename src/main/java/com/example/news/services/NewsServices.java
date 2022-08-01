package com.example.news.services;

import com.example.news.dob.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsServices {
     News save(News news);
     boolean isExist(String newsTitle);
     List<News> getAllNews();

}
