package com.example.news.dob;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long billingAccountId;
    private Date lastBillTime;
    private int priceId;
    private int subscriptionId;

    public Payments(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(Long billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public Date getLastBillTime() {
        return lastBillTime;
    }

    public void setLastBillTime(Date lastBillTime) {
        this.lastBillTime = lastBillTime;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
