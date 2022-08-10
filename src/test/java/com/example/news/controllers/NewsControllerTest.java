package com.example.news.controllers;

import com.example.news.dob.MyNews;
import com.example.news.dob.User;
import com.example.news.repository.NewsRepository;
import com.example.news.repository.UserRepository;
import com.example.news.services.NewsServices;
import liquibase.pro.packaged.M;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static liquibase.repackaged.net.sf.jsqlparser.util.validation.metadata.NamedObject.user;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class NewsControllerTest {

    @Autowired
    private NewsServices newsServices;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void newsForm() {
    }

    @Test
    void newsPage() {
    }

    @Test
    void getAllNews() {
    }

    @Test
    void testGetAllNews() {
    }

    @Test
    void yourNews() {
    }

    @Test
    public void savingProcess() {
        MyNews news = new MyNews();
        news.setTitle("Il");
        news.setLink("efef");
        news.setPubDate("ded@gmail.com");
        news.setDescription("$2a$12$qjV5NnJkBBM5SkxLIrW/CuuZi8Sn1ZF4ADq/yKMwSFNhHBP1ZXDK.");
        news.setGuid("efef");

        MyNews savedNews = newsServices.save(news);
        MyNews existUser = entityManager.find(MyNews.class, savedNews.getId());
        assertThat(existUser.getTitle()).isEqualTo(news.getTitle());
    }

    @Test
    void deleteNews() {
    }
}