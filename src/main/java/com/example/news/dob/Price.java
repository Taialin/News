package com.example.news.dob;


import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int costs;


    public Price(int subscriptionsCost, int newsCost) {
        this.costs = subscriptionsCost;
    }

    public Price() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int costs() {
        return costs;
    }

    public void costs(int subscriptionsCost) {
        this.costs = costs;
    }


}

