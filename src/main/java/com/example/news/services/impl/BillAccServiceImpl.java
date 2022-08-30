package com.example.news.services.impl;

import com.example.news.dob.BillAcc;
import com.example.news.repository.BillAccRepository;
import com.example.news.services.BillAccServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillAccServiceImpl implements BillAccServices {

    @Autowired
    private BillAccRepository billAccRepository;

    @Override
    public BillAcc save(BillAcc billAcc) {
        return billAccRepository.save(billAcc);
    }

    @Override
    public int findBillByUserId(Long id) {
        return billAccRepository.findBillByUserId(id);
    }
}
