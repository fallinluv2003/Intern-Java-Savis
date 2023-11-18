package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<HoaDon> getAll();

    HoaDon getDetail(UUID id);

    HoaDon getAllByTrangThai(UUID id);

    List<HoaDon> getAllByTrangThaiHoaDon();

    HoaDon add(HoaDon hoaDon);

    Page<HoaDon> findAllByTrangThai(Integer trangThai, Pageable pageable);

    Page<HoaDon> findAllPage(Pageable pageable);

}
