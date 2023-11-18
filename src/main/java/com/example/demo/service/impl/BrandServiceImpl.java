package com.example.demo.service.impl;

import com.example.demo.entity.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public List<Brand> getAllByTrangThai() {
        return brandRepository.getAllByTrangThai();
    }

    @Override
    public Brand getById(UUID id) {
        return brandRepository.getById(id);
    }

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void updateTrangThai(UUID id) {
        brandRepository.updateTrangThai(id);
    }
}
