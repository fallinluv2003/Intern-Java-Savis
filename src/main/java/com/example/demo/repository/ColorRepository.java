package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ColorRepository extends JpaRepository<MauSac, UUID> {
    @Query(value = "SELECT ms FROM MauSac ms WHERE ms.id=:id")
    MauSac getById(UUID id);

    @Query(value = "SELECT ms FROM MauSac ms WHERE ms.trangThai = 1")
    List<MauSac> getAllByTrangThai();
}
