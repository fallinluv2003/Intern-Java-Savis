package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class HistoryController {

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    private List<HoaDon> listHD = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    @GetMapping("/user/history")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "5") int size) {
//        int total = 0;
//
//        listHD = orderService.getAllByTrangThaiHoaDon();
//        for (HoaDon hoaDon : listHD) {
//            System.out.println(hoaDon.getId());
//            listHDCT = orderDetailService.getByIdHD();
//            List<HoaDonChiTiet> list = orderDetailService.getAll();
//            for (HoaDonChiTiet hoaDonChiTiet : list) {
//                if (hoaDonChiTiet.getHoaDon().getId().equals(hoaDon.getId())) {
//                    total += (hoaDonChiTiet.getSoLuong() * Integer.valueOf(hoaDonChiTiet.getDonGia() + ""));
//                }
//            }
//        }

        List<HoaDonChiTiet> list = orderDetailService.getAllByTrangThai();
        int countCart = list.size();
        model.addAttribute("page", page);
        Pageable pageable = PageRequest.of(page, size);
        Page<HoaDon> pageHD = orderService.findAllPage(pageable);
        model.addAttribute("countCart", countCart);
//        model.addAttribute("total", total);
        model.addAttribute("data", pageHD);
        return "/user/history";
    }

    @GetMapping("/user/history/status-0/{id}")
    public String userUpdateStatus(@PathVariable("id") UUID id) {
        listHD = orderService.getAllByTrangThaiHoaDon();
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getId().equals(id)) {
                hoaDon.setTrangThai(0);
                orderService.add(hoaDon);
            }
        }
        return "redirect:/user/history";
    }

    @GetMapping("/user/history/status-4/{id}")
    public String userUpdateStatus4(@PathVariable("id") UUID id) {
        listHD = orderService.getAllByTrangThaiHoaDon();
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getId().equals(id)) {
                hoaDon.setNgayNhan(new Date());
                hoaDon.setTrangThai(4);
                orderService.add(hoaDon);
            }
        }
        return "redirect:/user/history";
    }

    @GetMapping("/admin/history")
    public String loadHistory(Model model) {
//        int total = 0;

//        listHD = orderService.getAllByTrangThaiHoaDon();
//        for (HoaDon hoaDon : listHD) {
//            System.out.println(hoaDon.getId());
//            listHDCT = orderDetailService.getByIdHD();
//            List<HoaDonChiTiet> list = orderDetailService.getAll();
//            for (HoaDonChiTiet hoaDonChiTiet : list) {
//                if (hoaDonChiTiet.getHoaDon().getMa().equals(hoaDon.getMa())) {
//                    total += (hoaDonChiTiet.getSoLuong() * Integer.valueOf(hoaDonChiTiet.getDonGia() + ""));
//                }
//            }
//        }
//        listHD = orderService.getAllByTrangThaiHoaDon();
//        for (HoaDon hoaDon : listHD) {
        listHD = orderService.getAll();
        model.addAttribute("listOrder", listHD);
//        }
//        model.addAttribute("total", total);
        return "/admin/order";
    }

    @GetMapping("/user/history/detail/{id}")
    public String userDetail(Model model, @PathVariable("id") UUID id) {
        HoaDon hoaDon = orderService.getDetail(id);
        List<GioHang> list = cartService.getAllByTrangThai();
        int countCart = list.size();
        model.addAttribute("countCart", countCart);
        model.addAttribute("listOrderDetail", hoaDon.getListHDCT());
        return "/user/history-detail";
    }

    @GetMapping("/admin/history/detail/{id}")
    public String adminDetail(Model model, @PathVariable("id") UUID id) {
        HoaDon hoaDon = orderService.getDetail(id);
        model.addAttribute("listOrderDetail", hoaDon.getListHDCT());
        return "/admin/order-detail";
    }

    @GetMapping("/admin/history/status-0/{id}")
    public String userUpdateStatus0(@PathVariable("id") UUID id) {
        listHD = orderService.getAllByTrangThaiHoaDon();
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getId().equals(id)) {
                hoaDon.setTrangThai(0);
                orderService.add(hoaDon);
            }
        }
        return "redirect:/admin/history";
    }

    @GetMapping("/admin/history/status-2/{id}")
    public String adminUpdateStatus2(@PathVariable("id") UUID id) {
        listHD = orderService.getAllByTrangThaiHoaDon();
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getId().equals(id)) {
                hoaDon.setNgayThanhToan(new Date());
                hoaDon.setTrangThai(2);
                orderService.add(hoaDon);
            }
        }

        List<HoaDonChiTiet> list = orderDetailService.getByIdHoaDon(id);
        for (HoaDonChiTiet hoaDonChiTiet : list) {
            ChiTietSanPham chiTietSanPham = productService.getById(hoaDonChiTiet.getChiTietSanPham().getId());
            if (hoaDonChiTiet.getChiTietSanPham().getId().equals(chiTietSanPham.getId())) {
                Integer soLuong = chiTietSanPham.getSoLuong() - hoaDonChiTiet.getSoLuong();
                System.out.println("Số lượng: " + soLuong);
                productService.updateSoLuong(soLuong, chiTietSanPham.getId());
            }
        }
        return "redirect:/admin/history";
    }

    @GetMapping("/admin/history/status-3/{id}")
    public String adminUpdateStatus3(@PathVariable("id") UUID id) {
        listHD = orderService.getAllByTrangThaiHoaDon();
        for (HoaDon hoaDon : listHD) {
            if (hoaDon.getId().equals(id)) {
                hoaDon.setNgayShip(new Date());
                hoaDon.setTrangThai(3);
                orderService.add(hoaDon);
            }
//            List<HoaDonChiTiet> list = orderDetailService.getByIdHoaDon(hoaDon.getId());
//            for (HoaDonChiTiet hoaDonChiTiet : list) {
//                ChiTietSanPham chiTietSanPham = productService.getById(hoaDonChiTiet.getChiTietSanPham().getId());
//                if (hoaDonChiTiet.getChiTietSanPham().getId().equals(chiTietSanPham.getId())) {
//                    Integer soLuong = chiTietSanPham.getSoLuong() - hoaDonChiTiet.getSoLuong();
//                    System.out.println("Số lượng: " + soLuong);
//                    productService.updateSoLuong(soLuong, chiTietSanPham.getId());
//                }
//            }
        }
        return "redirect:/admin/history";
    }

}
