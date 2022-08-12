package com.example.news.services;

import com.example.news.dob.MyNews;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsServices {
    MyNews save(MyNews news);
    boolean isExist(String newsTitle);
    List<MyNews> getAllNews();
    List<MyNews> getAllNews(String keyword);

    boolean deleteNews(Long newsId);



}
