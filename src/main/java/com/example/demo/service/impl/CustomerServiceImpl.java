package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public KhachHang getById() {
        return customerRepository.getById();
    }
}
