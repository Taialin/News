package com.example.news.dob;


import javax.persistence.*;

@Entity
@Table(name = "ucer_choice")
public class UserChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sub_id")
    private int subId;
    @Column(name = "news_id")
    private int newsId;
    @Column(name = "user_id")
    private int userId;

 
    public UserChoice(int subId, int newsId, int userId) {
        this.subId = subId;
        this.newsId = newsId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int news_id) {
        this.newsId = news_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int sub_id) {
        this.subId = sub_id;
    }


}
