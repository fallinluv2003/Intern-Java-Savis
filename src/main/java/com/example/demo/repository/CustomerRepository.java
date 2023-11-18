package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<KhachHang, UUID> {

    @Query(value = "SELECT kh FROM KhachHang kh WHERE kh.id = 'F824CB2D-DCB2-4501-8174-D54F3E12E830'")
    KhachHang getById();

}
