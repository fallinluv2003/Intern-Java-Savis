package com.example.demo.service;

import com.example.demo.entity.NhanVien;

import java.util.List;

public interface EmployeeService {
    List<NhanVien> getAll();

    NhanVien add(NhanVien nhanVien);
}
