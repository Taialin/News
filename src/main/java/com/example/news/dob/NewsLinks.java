package com.example.news.dob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "link_news")
public class NewsLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String linkRSS;

        @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "user_choice",
            joinColumns = @JoinColumn(name = "sub_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private Set<User> subscriptions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "user_choice",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private Set<Subscriptions>  users;

    public NewsLinks(){}

    public NewsLinks(String linkRSS){
        this.linkRSS = linkRSS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkRSS() {
        return linkRSS;
    }

    public void setLinkRSS(String linkRSS) {
        this.linkRSS = linkRSS;
    }
}
