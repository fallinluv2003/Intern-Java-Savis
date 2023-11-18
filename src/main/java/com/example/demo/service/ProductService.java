package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ChiTietSanPham> getAll();

    List<ChiTietSanPham> getAllByTrangThai();

    List<ChiTietSanPham> getAllOrderByAsc();

    Page<ChiTietSanPham> findAllPage(Pageable pageable);

    ChiTietSanPham getById(UUID id);

    ChiTietSanPham add(ChiTietSanPham chiTietSanPham);

    void updateSoLuong(Integer soLuong, UUID id);
}
