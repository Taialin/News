package com.example.news.services;

import com.example.news.dob.NewsCategory;
import com.example.news.dob.NewsLinks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsCategoryServices {
    NewsCategory save(NewsCategory newsCategory);
    List<NewsCategory> findAll();
    List<NewsCategory> findAllByIds(List<Long> ids);

}
