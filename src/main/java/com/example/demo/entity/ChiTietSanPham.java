package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="chi_tiet_sp")
public class ChiTietSanPham {

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="ma")
    private String ma;

    @Column(name="ten_sp")
    private String ten;

    @ManyToOne
    @JoinColumn(name="id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name="id_danh_muc")
    private DanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name="id_chat_lieu")
    private ChatLieu chatLieu;

    @Column(name="image")
    private String image;

    @Column(name="so_luong")
    private Integer soLuong;

    @Column(name="gia_nhap")
    private BigDecimal giaNhap;

    @Column(name="gia_ban")
    private BigDecimal giaBan;

    @Column(name="mo_ta")
    private String moTa;

    @Column(name="trang_thai")
    private Integer trangThai;

    @OneToMany(mappedBy = "chiTietSanPham", fetch = FetchType.EAGER)
    private List<HoaDonChiTiet> listHDCT;

    @OneToMany(mappedBy = "chiTietSanPham", fetch = FetchType.EAGER)
    private List<GioHang> gioHangList;

}
