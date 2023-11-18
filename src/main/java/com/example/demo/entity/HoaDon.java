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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="hoa_don")
public class HoaDon {

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHDCT;

    @ManyToOne
    @JoinColumn(name = "id_kh")
    private KhachHang khachHang;

    @Column(name = "ma")
    private String ma;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_ship")
    private Date ngayShip;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_nhan")
    private Date ngayNhan;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_thanh_toan")
    private Date ngayThanhToan;


    @Column(name = "nguoi_nhan")
    @NotEmpty(message = "Vui lòng không để trống tên.")
    private String nguoiNhan;

    @Column(name = "dia_chi")
    @NotEmpty(message = "Vui lòng không để trống địa chỉ.")
    private String diaChi;

    @Column(name = "sdt")
    @NotEmpty(message = "Vui lòng không để trống số điện thoại.")
    private String sdt;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
