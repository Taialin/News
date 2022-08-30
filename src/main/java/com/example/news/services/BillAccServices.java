package com.example.news.services;

import com.example.news.dob.BillAcc;

public interface BillAccServices {
    BillAcc save(BillAcc billAcc);
    int findBillByUserId(Long id);
}
