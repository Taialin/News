package com.example.news.repository;

import com.example.news.dob.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
    @Query("SELECT max(r.lastBillTime) FROM Payments r where r.billingAccountId = :billingAccountId and r.subscriptionId = :subscriptionId")
    Date findDateByById(@Param("billingAccountId") Long billingAccountId, @Param("subscriptionId") int subscriptionId);
}

