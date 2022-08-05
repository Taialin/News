package com.example.news.dob;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titleOfSub;
    private int cost;
    private int status;
    private Date term;

    public Subscriptions(String titleOfSub, int cost, int status, Date term) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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