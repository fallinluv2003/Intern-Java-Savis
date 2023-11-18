package com.example.demo.service.impl;

import com.example.demo.entity.HoaDon;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderSerivceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<HoaDon> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public HoaDon getDetail(UUID id) {
        return orderRepository.getDetail(id);
    }

    @Override
    public HoaDon getAllByTrangThai(UUID id) {
        return orderRepository.getAllByTrangThai(id);
    }

    @Override
    public List<HoaDon> getAllByTrangThaiHoaDon() {
        return orderRepository.getAllByTrangThaiHoaDon();
    }

    @Override
    public HoaDon add(HoaDon hoaDon) {
        return orderRepository.save(hoaDon);
    }

    @Override
    public Page<HoaDon> findAllByTrangThai(Integer trangThai, Pageable pageable) {
        return orderRepository.findAllByTrangThai(trangThai, pageable);
    }

    @Override
    public Page<HoaDon> findAllPage(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

}
