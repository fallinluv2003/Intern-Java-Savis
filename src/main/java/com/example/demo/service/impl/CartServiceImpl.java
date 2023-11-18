package com.example.demo.service.impl;

import com.example.demo.entity.GioHang;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void updateSoLuongGioHang(Integer soLuong, UUID id) {
        cartRepository.updateSoLuongGioHang(soLuong, id);
    }

    @Override
    public List<GioHang> getAllByTrangThai() {
        return cartRepository.getAllByTrangThai();
    }

    @Override
    public GioHang add(GioHang gioHang) {
        return cartRepository.save(gioHang);
    }

    @Override
    public GioHang getById(UUID id) {
        return cartRepository.getById(id);
    }

    @Override
    public GioHang getAllTrangThai() {
        return cartRepository.getAllTrangThai();
    }

    @Override
    public List<GioHang> getByIdGioHang(UUID id) {
        return cartRepository.getByIdGioHang(id);
    }

    @Override
    public void delete(GioHang gioHang) {
        cartRepository.delete(gioHang);
    }

    @Override
    public void updateTrangThaiGioHang() {
        cartRepository.updateTrangThaiGioHang(); ;
    }
}
