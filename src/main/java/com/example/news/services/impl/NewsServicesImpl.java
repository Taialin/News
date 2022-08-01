package com.example.news.services.impl;

import com.example.news.dob.News;
import com.example.news.repository.NewsRepository;
import com.example.news.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServicesImpl implements NewsServices {

    @Autowired
    NewsRepository repository;

    @Override
    public News save(News news) {
        return  repository.save(news);

    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> news = repository.findAll();
        for(News n: news){
            if(n.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();

    }

    @Override
    public List<News> findByTitle(String title) {
        return  getAllNews().stream().filter(news -> title.equals(news.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<News> findAllByCategory(List<String> category ) {
        return  getAllNews().stream().filter(news -> category.contains(news.getCategory())).collect(Collectors.toList());
    }


}
