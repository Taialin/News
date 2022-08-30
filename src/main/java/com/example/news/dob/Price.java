package com.example.news.dob;


import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int costs;
    private String subForm;


    public Price() {

    }

    public Price(int costs, String subForm){
        this.costs = costs;
        this.subForm = subForm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    public String getSubForm() {
        return subForm;
    }

    public void setSubForm(String subForm) {
        this.subForm = subForm;
    }
}

