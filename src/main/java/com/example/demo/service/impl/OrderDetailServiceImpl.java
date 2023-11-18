package com.example.demo.service.impl;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.model.HoaDonCustom;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<HoaDonChiTiet> getAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<HoaDonChiTiet> getAllByTrangThai() {
        return orderDetailRepository.getAllByTrangThai();
    }

    @Override
    public List<HoaDonChiTiet> getByIdHD() {
        return orderDetailRepository.getByIdHD();
    }

    @Override
    public List<HoaDonChiTiet> getByIdHoaDon(UUID id) {
        return orderDetailRepository.getByIdHoaDon(id);
    }

    @Override
    public List<HoaDonChiTiet> getAllByHoaDonCho() {
        return orderDetailRepository.getAllByHoaDonCho();
    }

    @Override
    public HoaDonChiTiet findById(UUID id) {
        return orderDetailRepository.getById(id);
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
        return orderDetailRepository.save(hoaDonChiTiet);
    }

    @Override
    public void update(Integer soLuong, UUID id) {
        orderDetailRepository.update(soLuong, id);
    }

    @Override
    public void delete(HoaDonChiTiet hoaDonChiTiet) {
        orderDetailRepository.delete(hoaDonChiTiet);
    }

    @Override
    public void updateHoaDon(HoaDon hoaDon) {
        orderDetailRepository.updateHoaDon(hoaDon);
    }

    @Override
    public void updateTrangThai(HoaDon hoaDon) {
        orderDetailRepository.updateTrangThai(hoaDon);
    }

    @Override
    public HoaDonChiTiet getByHoaDonId(UUID id) {
        return orderDetailRepository.getByHoaDonId(id);
    }

    @Override
    public Page<HoaDonChiTiet> findAllPage(Pageable pageable) {
        return orderDetailRepository.findAll(pageable);
    }

    @Override
    public List<HoaDonChiTiet> findAllByHoaDon_IdAndHoaDon_TrangThaiAndTrangThai(UUID id, Integer trangThaiHD, Integer trangThaiHDCT) {
        return orderDetailRepository.findAllByHoaDon_IdAndHoaDon_TrangThaiAndTrangThai(id, trangThaiHD, trangThaiHDCT);
    }

    @Override
    public List<HoaDonChiTiet> getAllHoaDonCustom() {
        return orderDetailRepository.getAllHoaDonCustom();
    }

}
