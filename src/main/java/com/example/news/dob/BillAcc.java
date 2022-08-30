package com.example.news.dob;

import javax.persistence.*;

@Entity
@Table(name ="billing_acc")
public class BillAcc {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private int money;


    public BillAcc(Long userId, int money) {
        this.userId = userId;
        this.money = money;
    }

    public BillAcc() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
