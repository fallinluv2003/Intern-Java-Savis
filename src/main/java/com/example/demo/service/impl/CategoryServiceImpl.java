package com.example.demo.service.impl;

import com.example.demo.entity.DanhMuc;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<DanhMuc> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<DanhMuc> getAllByTrangThai() {
        return categoryRepository.getAllByTrangThai();
    }

    @Override
    public DanhMuc getById(UUID id) {
        return categoryRepository.getById(id);
    }

    @Override
    public DanhMuc add(DanhMuc danhMuc) {
        return categoryRepository.save(danhMuc);
    }
}
