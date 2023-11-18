package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.model.HoaDonCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService {

    List<HoaDonChiTiet> getAll();

    List<HoaDonChiTiet> getAllByTrangThai();

    List<HoaDonChiTiet> getByIdHD();

    List<HoaDonChiTiet> getByIdHoaDon(UUID id);

    List<HoaDonChiTiet> getAllByHoaDonCho();

    HoaDonChiTiet findById(UUID id);

    HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet);

    void update(Integer soLuong, UUID id);

    void delete(HoaDonChiTiet hoaDonChiTiet);

    void updateHoaDon(HoaDon hoaDon);

    void updateTrangThai(HoaDon hoaDon);

    HoaDonChiTiet getByHoaDonId(UUID id);

    Page<HoaDonChiTiet> findAllPage(Pageable pageable);

    List<HoaDonChiTiet> findAllByHoaDon_IdAndHoaDon_TrangThaiAndTrangThai(UUID id, Integer trangThaiHD, Integer trangThaiHDCT);

    List<HoaDonChiTiet> getAllHoaDonCustom();

}
