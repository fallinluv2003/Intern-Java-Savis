package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<NhanVien> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public NhanVien add(NhanVien nhanVien) {
        return employeeRepository.save(nhanVien);
    }
}
