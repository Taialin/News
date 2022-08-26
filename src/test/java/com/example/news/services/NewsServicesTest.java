package com.example.news.services;

import com.example.news.dob.MyNews;
import com.example.news.repository.NewsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@Transactional
@SpringBootTest
class NewsServicesTest {

    @Autowired
    private NewsServices newsServices;

    @MockBean
    private NewsRepository newsRepository;

    @Test
    void save() {
    }

    @Test
    void getAllNews() {
        List<MyNews> news = new ArrayList<>();
        news.add(new MyNews());
        given(newsRepository.findAll()).willReturn(news);
        List<MyNews> exp = newsServices.getAllNews();

        assertEquals(exp, news);
    }

    @Test
    void deleteOneNews() {
        MyNews news = new MyNews();
        news.setTitle("123");
        given(newsRepository.save(news)).willReturn(news);
        MyNews savedNews = newsServices.save(news);

        when(newsRepository.findById(savedNews.getId())).thenReturn(Optional.of(savedNews));
        newsServices.deleteNews(savedNews.getId());
        verify(newsRepository).deleteById(news.getId());

    }

}