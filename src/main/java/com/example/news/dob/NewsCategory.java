package com.example.news.dob;


import javax.persistence.*;

@Entity
@Table(name = "news_category")
public class NewsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String news_category;

    public NewsCategory(String news_category) {
        this.news_category = news_category;
    }

    public NewsCategory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNews_category() {
        return news_category;
    }

    public void setNews_category(String news_category) {
        this.news_category = news_category;
    }
}
