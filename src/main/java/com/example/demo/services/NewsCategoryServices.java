package com.example.demo.services;

import com.example.demo.dob.NewsCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsCategoryServices {
    NewsCategory save(NewsCategory newsCategory);
    List<NewsCategory> findAll();
    List<NewsCategory> findAllByIds(List<Long> ids);

}
