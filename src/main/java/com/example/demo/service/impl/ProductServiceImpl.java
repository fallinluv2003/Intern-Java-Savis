package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ChiTietSanPham> getAllByTrangThai() {
        return getAllByTrangThai();
    }

    @Override
    public List<ChiTietSanPham> getAllOrderByAsc() {
        return productRepository.getAllOrderByAsc();
    }

    @Override
    public Page<ChiTietSanPham> findAllPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public ChiTietSanPham getById(UUID id) {
        return productRepository.getById(id);
    }

    @Override
    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        return productRepository.save(chiTietSanPham);
    }

    @Override
    public void updateSoLuong(Integer soLuong, UUID id) {
        productRepository.updateSoLuong(soLuong, id);
    }
}
