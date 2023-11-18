package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<HoaDon, UUID> {
    @Query(value = "SELECT hd FROM HoaDon hd WHERE hd.id=:id")
    HoaDon getAllByTrangThai(UUID id);

    @Query(value = "SELECT hd FROM HoaDon hd WHERE hd.id=:id")
    HoaDon getDetail(UUID id);

    @Query(value = "SELECT hd FROM HoaDon hd")
    List<HoaDon> getAllByTrangThaiHoaDon();
    
    Page<HoaDon> findAllByTrangThai(Integer trangThai, Pageable pageable);

}
