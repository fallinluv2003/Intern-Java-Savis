package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<HoaDonChiTiet, UUID> {

    @Modifying()
    @Query(value = "UPDATE HoaDonChiTiet hdct SET hdct.soLuong=:soLuong WHERE hdct.chiTietSanPham.id=:id")
    void update(@Param("soLuong") Integer soLuong,@Param("id") UUID id);

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.trangThai = 0")
    List<HoaDonChiTiet> getAllByTrangThai();

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.trangThai = 1")
    List<HoaDonChiTiet> getAllByHoaDonCho();

    List<HoaDonChiTiet> findAllByHoaDon_IdAndHoaDon_TrangThaiAndTrangThai(UUID id, Integer trangThaiHD, Integer trangThaiHDCT);

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.khachHang.id = 'DD69636A-417D-4239-A24A-29F19564C1D1'")
    List<HoaDonChiTiet> getByIdHD();

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.id=:id")
    HoaDonChiTiet getById(UUID id);

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.id=:id AND hdct.hoaDon.trangThai = 2 AND hdct.trangThai = 1")
    List<HoaDonChiTiet> getByIdHoaDon(UUID id);

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.hoaDon.id=:id AND hdct.hoaDon.trangThai = 1")
    HoaDonChiTiet getByHoaDonId(UUID id);

    @Modifying()
    @Query(value = "UPDATE HoaDonChiTiet hdct SET hdct.hoaDon=:hoaDon, hdct.trangThai = 1 WHERE hdct.trangThai = 0")
    void updateHoaDon(@Param("hoaDon") HoaDon hoaDon);

    @Modifying()
    @Query(value = "UPDATE HoaDonChiTiet hdct SET hdct.trangThai = 1 WHERE hdct.hoaDon=:hoaDon")
    void updateTrangThai(@Param("hoaDon") HoaDon hoaDon);

    @Modifying()
    @Query(value = "UPDATE HoaDonChiTiet hdct SET hdct.chiTietSanPham.soLuong=:soLuong WHERE hdct.chiTietSanPham.id=:id")
    void updateSoLuong(@Param("soLuong") Integer soLuong, @Param("id") UUID id);

    @Query(value = "SELECT hdct FROM HoaDonChiTiet hdct WHERE hdct.trangThai = 1")
    List<HoaDonChiTiet> getAllHoaDonCustom();

}


