package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ProductPagingRepository;
import com.example.demo.service.ProductPagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductPagingServiceImpl implements ProductPagingService {

    @Autowired
    private ProductPagingRepository productPagingRepository;

    @Override
    public Page<ChiTietSanPham> findAllByTrangThai(Integer trangThai, Pageable pageable) {
        return productPagingRepository.findAllByTrangThai(trangThai, pageable);
    }

    @Override
    public Page<ChiTietSanPham> findAllByTrangThaiOrderByGiaBanAsc(Integer trangThai, Pageable pageable) {
        return productPagingRepository.findAllByTrangThaiOrderByGiaBanAsc(trangThai, pageable);
    }

    @Override
    public Page<ChiTietSanPham> findAllByTrangThaiOrderByGiaBanDesc(Integer trangThai, Pageable pageable) {
        return productPagingRepository.findAllByTrangThaiOrderByGiaBanDesc(trangThai, pageable);
    }
}
