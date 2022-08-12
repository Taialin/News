package com.example.news.dob;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleOfSub;
    @ManyToOne
    @JoinColumn(name="cost")
    private Price cost;
    private int status;
    private Date term;

    public Subscriptions(String titleOfSub, Price cost, int status, Date term) {
        this.titleOfSub = titleOfSub;
        this.cost = cost;
        this.status = status;
        this.term = term;
    }

    public Subscriptions() {

    }

    public String getTitleOfSub() {
        return titleOfSub;
    }

    public void setTitleOfSub(String titleOfSub) {
        this.titleOfSub = titleOfSub;
    }

    public Price getCost() {
        return cost;
    }

    public void setCost(Price cost) {
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}