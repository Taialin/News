package com.example.demo.services.impl;

import com.example.demo.dob.NewsCategory;
import com.example.demo.repository.NewsCategoryRepository;
import com.example.demo.services.NewsCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsCategoryServiceImpl implements NewsCategoryServices {
    @Autowired
    NewsCategoryRepository newsCategoryRepository;

    @Override
    public NewsCategory save(NewsCategory newsCategory) {
        return  newsCategoryRepository.save(newsCategory);

    }
    public List<NewsCategory> findAll() {
        return newsCategoryRepository.findAll();
    }

    @Override
    public List<NewsCategory> findAllByIds(List<Long> ids) {
        return findAll().stream().filter(place -> ids.contains(place.getId())).collect(Collectors.toList());
    }

}
