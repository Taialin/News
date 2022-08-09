package com.example.news.services.impl;

import com.example.news.dob.MyNews;
import com.example.news.dob.NewsCategory;
import com.example.news.repository.NewsRepository;
import com.example.news.services.NewsCategoryServices;
import com.example.news.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public boolean isExist(String newsTitle) {
        List<MyNews> news = repository.findAll();
        for (MyNews n : news) {
            if (n.getTitle().equals(newsTitle)) {
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
        List<NewsCategory> allCategories = newsCategoryServices.findAll();
        List<NewsCategory> matchedCategories = allCategories.stream().filter(category -> keyword.equals(category.getNews_category())).collect(Collectors.toList());
        List<MyNews> result = new ArrayList<>();
        matchedCategories.stream().map(NewsCategory::getNews).forEach(result::addAll);
        return result;
    }

    @Override
    public boolean deleteNews(Long newsId) {
        if (repository.findById(newsId).isPresent()) {
            repository.deleteById(newsId);
            return true;
        }
        return false;
    }

        @Override
    public List<MyNews> findByTitle(String title) {
        return getAllNews().stream().filter(news -> title.equals(news.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<MyNews> findAllByCategory(List<String> categories) {
        List<MyNews> alLNews = repository.findAll();
        List<MyNews> result = new ArrayList<>();
        for (MyNews news : alLNews) {
            for (String category : categories) {
                boolean match = news.getCategories().stream().anyMatch(newsCategory -> category.equals(newsCategory.getNews_category()));
                if (match) {
                    result.add(news);
                    break;
                }
            }
        }
        return result;
    }
}
