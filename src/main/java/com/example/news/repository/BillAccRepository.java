package com.example.news.repository;

import com.example.news.dob.BillAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BillAccRepository  extends JpaRepository<BillAcc, Integer> {

    @Query("SELECT r.money FROM BillAcc r where r.id = :id")
    int findMoneyById(@Param("id") Long id);
    
    @Transactional
    @Modifying
    @Query("update BillAcc billAcc set billAcc.money = ?1 where billAcc.id = ?2")
    int updateUserMoney(Integer money, Long id);

    @Query("SELECT r.id FROM BillAcc r where r.userId = :id")
    int findBillByUserId(@Param("id") Long id);


}
