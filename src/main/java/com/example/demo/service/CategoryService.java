package com.example.demo.service;

import com.example.demo.entity.DanhMuc;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<DanhMuc> getAll();

    List<DanhMuc> getAllByTrangThai();

    DanhMuc getById(UUID id);

    DanhMuc add(DanhMuc danhMuc);
}
