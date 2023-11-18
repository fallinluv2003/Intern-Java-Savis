package com.example.demo.repository;

import com.example.demo.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<DanhMuc, UUID> {
    @Query(value = "SELECT dm FROM DanhMuc dm WHERE dm.id=:id")
    DanhMuc getById(UUID id);

    @Query(value = "SELECT dm FROM DanhMuc dm WHERE dm.trangThai = 1")
    List<DanhMuc> getAllByTrangThai();
}
