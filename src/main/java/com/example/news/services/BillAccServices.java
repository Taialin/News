package com.example.news.services;

import com.example.news.dob.BillAcc;
import org.springframework.stereotype.Service;

public interface BillAccServices {
    BillAcc save(BillAcc billAcc);
    int findBillByUserId(Long id);
}
