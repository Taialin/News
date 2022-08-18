package com.example.news.services.impl;

import com.example.news.dob.MyNews;
import com.example.news.repository.NewsRepository;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServicesImpl implements NewsServices {

    @Autowired
    private NewsRepository repository;
    @Autowired
    private NewsCategoryServices newsCategoryServices;


    @Override
    public MyNews save(MyNews news) {
        return repository.save(news);
    }

    @Override
    public boolean isExist(String link) {
        List<MyNews> news = repository.findAll();
        for (MyNews n : news) {
            if (n.getLink().equals(link)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MyNews> getAllNews() {
        return repository.findAll();
    }

    @Override
    public List<MyNews> getAllNews(String keyword) {

        return repository.findAllByCategoryName(keyword);
    }

    @Override
    public List<MyNews> save() {
        return repository.findAll();
    }

    @Override
    public boolean deleteNews(Long newsId) {
        if (repository.findById(newsId).isPresent()) {
            repository.deleteById(newsId);
            return true;
        }
        return false;
    }
}
