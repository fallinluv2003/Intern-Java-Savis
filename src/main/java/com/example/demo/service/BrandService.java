package com.example.demo.service;

import com.example.demo.entity.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<Brand> getAll();

    List<Brand> getAllByTrangThai();

    Brand getById(UUID id);

    Brand add(Brand brand);

    void updateTrangThai(UUID id);
}
