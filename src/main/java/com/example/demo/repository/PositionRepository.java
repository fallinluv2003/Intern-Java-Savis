package com.example.demo.repository;

import com.example.demo.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<ChucVu, UUID> {

    @Query(value = "SELECT cv FROM ChucVu cv WHERE cv.trangThai = 1")
    List<ChucVu> getAllByTrangThai();

}
