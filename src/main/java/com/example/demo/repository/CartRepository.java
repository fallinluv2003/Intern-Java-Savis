package com.example.demo.repository;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.HoaDon;
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
public interface CartRepository extends JpaRepository<GioHang, UUID> {

    @Modifying()
    @Query(value = "UPDATE GioHang gh SET gh.soLuong=:soLuong WHERE gh.chiTietSanPham.id=:id")
    void updateSoLuongGioHang(@Param("soLuong") Integer soLuong,@Param("id") UUID id);

    @Query(value = "SELECT gh FROM GioHang gh WHERE gh.trangThai = 0")
    List<GioHang> getAllByTrangThai();

    @Query(value = "SELECT gh FROM GioHang gh WHERE gh.idGioHang=:id AND gh.trangThai = 0")
    List<GioHang> getByIdGioHang(UUID id);

    @Query(value = "SELECT gh FROM GioHang gh WHERE gh.idGioHang=:id AND gh.trangThai = 0")
    GioHang getById(UUID id);

    @Query(value = "SELECT gh FROM GioHang gh WHERE gh.trangThai = 0")
    GioHang getAllTrangThai();

    @Modifying()
    @Query(value = "UPDATE GioHang gh SET gh.trangThai = 1 WHERE gh.trangThai = 0")
    void updateTrangThaiGioHang();

}
