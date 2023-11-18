package com.example.demo.service;

import com.example.demo.entity.GioHang;

import java.util.List;
import java.util.UUID;

public interface CartService {

    void updateSoLuongGioHang(Integer soLuong, UUID id);

    List<GioHang> getAllByTrangThai();

    GioHang add(GioHang gioHang);

    GioHang getById(UUID id);

    GioHang getAllTrangThai();

    List<GioHang> getByIdGioHang(UUID id);

    void delete(GioHang gioHang);

    void updateTrangThaiGioHang();

}
