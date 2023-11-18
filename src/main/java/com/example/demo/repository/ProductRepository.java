package com.example.demo.repository;

import com.example.demo.entity.ChiTietSanPham;
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
public interface ProductRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "SELECT ctsp FROM ChiTietSanPham ctsp WHERE ctsp.id=:id")
    ChiTietSanPham getById(UUID id);

    @Modifying()
    @Query(value = "UPDATE ChiTietSanPham ctsp SET ctsp.soLuong=:soLuong WHERE ctsp.id=:id")
    void updateSoLuong(@Param("soLuong") Integer soLuong, @Param("id") UUID id);

    @Query(value = "SELECT ctsp FROM ChiTietSanPham ctsp WHERE ctsp.trangThai = 1")
    List<ChiTietSanPham> getAllByTrangThai();

    @Query(value = "SELECT ctsp FROM ChiTietSanPham ctsp WHERE ctsp.trangThai = 1 ORDER BY ctsp.giaBan ASC")
    List<ChiTietSanPham> getAllOrderByAsc();

}
