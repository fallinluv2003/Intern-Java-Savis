package com.example.demo.service;

import com.example.demo.entity.ChucVu;

import java.util.List;

public interface PositionService {
    List<ChucVu> getAll();

    List<ChucVu> getAllByTrangThai();

    ChucVu add(ChucVu chucVu);
}
