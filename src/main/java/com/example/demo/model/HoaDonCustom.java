package com.example.demo.model;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoaDonCustom {
    
    private String ma;
    private BigDecimal tongTien;
    private String sdt;
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    private Integer trangThai;
    
}
