package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductPagingService {

    Page<ChiTietSanPham> findAllByTrangThai(Integer trangThai, Pageable pageable);

    Page<ChiTietSanPham> findAllByTrangThaiOrderByGiaBanAsc(Integer trangThai, Pageable pageable);

    Page<ChiTietSanPham> findAllByTrangThaiOrderByGiaBanDesc(Integer trangThai, Pageable pageable);

}
