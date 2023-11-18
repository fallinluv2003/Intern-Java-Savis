package com.example.demo.repository;

import com.example.demo.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
    @Query(value = "SELECT br FROM Brand br WHERE br.id=:id")
    Brand getById(UUID id);

    @Query(value = "SELECT br FROM Brand br WHERE br.trangThai = 1")
    List<Brand> getAllByTrangThai();

    @Modifying
    @Query(value = "UPDATE Brand br SET br.trangThai = 0 WHERE br.id =: id")
    void updateTrangThai(@Param("id") UUID id);
}
