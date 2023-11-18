package com.example.demo.repository;

import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductPagingRepository extends PagingAndSortingRepository<ChiTietSanPham, UUID> {

    Page<ChiTietSanPham> findAllByTrangThai(Integer trangThai, Pageable pageable);

    Page<ChiTietSanPham> findAllByTrangThaiOrderByGiaBanAsc(Integer trangThai, Pageable pageable);

    Page<ChiTietSanPham> findAllByTrangThaiOrderByGiaBanDesc(Integer trangThai, Pageable pageable);

}
