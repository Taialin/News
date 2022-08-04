package com.example.news.services.impl;

import com.example.news.dob.MyNews;
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
    public MyNews save(MyNews news) {
        return  repository.save(news);

    }

    @Override
    public boolean isExist(String newsTitle) {
        List<MyNews> news = repository.findAll();
        for(MyNews n: news){
            if(n.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MyNews> getAllNewss() {
        return repository.findAll();
    }

    @Override
    public List<MyNews> getAllNews(String keyword) {
        if (keyword != null)
        { return repository.findAll(keyword);}
        return repository.findAll();
    }

    @Override
    public List<MyNews> findByTitle(String title) {
        return  getAllNewss().stream().filter(news -> title.equals(news.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<MyNews> findAllByCategory(List<String> category ) {
        return  getAllNewss().stream().filter(news -> category.contains(news.getCategory())).collect(Collectors.toList());
    }


}
