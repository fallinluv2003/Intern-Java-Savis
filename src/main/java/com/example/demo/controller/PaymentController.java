package com.example.demo.controller;

import com.example.demo.entity.GioHang;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    private List<GioHang> gioHangList = new ArrayList<>();

    @GetMapping("/user/payment")
    public String hienThi(Model model, RedirectAttributes redirectAttributes) {
        int total = 0;
        gioHangList = cartService.getAllByTrangThai();
        for (GioHang gioHang : gioHangList) {
            System.out.println("Giỏ hàng 1: " + gioHang.toString());
            total += (gioHang.getSoLuong() * Integer.valueOf(gioHang.getDonGia() + ""));
        }
        int countCart = gioHangList.size();
        model.addAttribute("payment", new HoaDon());
        model.addAttribute("countCart", countCart);
        model.addAttribute("total", total);
        model.addAttribute("listCart", gioHangList);

        if (gioHangList.size() > 0) {
            return "/user/payment";
        } else {
            redirectAttributes.addFlashAttribute("message", "Giỏ hàng trống không thể thanh toán");
            return "redirect:/user/cart";
        }

    }

    @PostMapping("/user/payment/add")
    public String themHoaDon(@Valid @ModelAttribute("payment") HoaDon hoaDon,
                             BindingResult result, RedirectAttributes redirectAttributes) {
        List<HoaDon> listHD = orderService.getAll();
        KhachHang khachHang = customerService.getById();
        gioHangList = cartService.getAllByTrangThai();

        if (result.hasErrors()) {
            return "redirect:/user/payment";
        }

        String ma = "";
        ma = "HD" + (listHD.size() + 1);
        hoaDon.setMa(ma);
        hoaDon.setKhachHang(khachHang);
        hoaDon.setNgayTao(new Date());
        hoaDon.setTrangThai(1);
        orderService.add(hoaDon);
        System.out.println(hoaDon.getId());

        for (GioHang gh : gioHangList) {
            System.out.println("Giỏ hàng 2: " + gh.toString());
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setChiTietSanPham(gh.getChiTietSanPham());
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setDonGia(gh.getDonGia());
            hoaDonChiTiet.setSoLuong(gh.getSoLuong());
            hoaDonChiTiet.setTrangThai(1);
            System.out.println("Hóa đơn chi tiết: " + hoaDonChiTiet.toString());
            orderDetailService.add(hoaDonChiTiet);
        }
        cartService.updateTrangThaiGioHang();

        redirectAttributes.addFlashAttribute("message", "Đặt hàng thành công");
        return "redirect:/user/cart";
    }

}
