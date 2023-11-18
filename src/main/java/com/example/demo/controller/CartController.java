package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class CartController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    private List<GioHang> list = new ArrayList<>();

    @GetMapping("/user/cart")
    public String hienThi(Model model) {
        int total = 0;
        list = cartService.getAllByTrangThai();
        for (GioHang gioHang : list) {
            total += (gioHang.getSoLuong() * Integer.valueOf(gioHang.getDonGia() + ""));
        }
        int countCart = list.size();
        model.addAttribute("countCart", countCart);
        model.addAttribute("total", total);
        model.addAttribute("listCart", list);
        return "/user/cart";
    }

    @PostMapping("/user/add-cart/{id}")
    public String save(@PathVariable("id") UUID id,
                       @RequestParam("quantity") Integer quantity,
                       RedirectAttributes redirectAttributes) {
        ChiTietSanPham chiTietSanPham = productService.getById(id);
        KhachHang khachHang = customerService.getById();
        list = cartService.getAllByTrangThai();
        GioHang cart = new GioHang();

        if (quantity > chiTietSanPham.getSoLuong()) {
            redirectAttributes.addFlashAttribute("message", "Vượt quá số lượng cho phép");
            return "redirect:/user/detail/" + id;
        }

        for (GioHang gioHang : list) {
            if (gioHang.getChiTietSanPham().getId().equals(id)) {
                gioHang.setSoLuong(gioHang.getSoLuong() + quantity);
            }
        }

        boolean update = true;
        for (GioHang gioHang : list) {
            if (gioHang.getChiTietSanPham().getId().equals(id)) {
                Integer sl = gioHang.getSoLuong();
                cartService.updateSoLuongGioHang(sl, gioHang.getChiTietSanPham().getId());
                update = false;
            }
        }

        if (update == true) {
            cart.setKhachHang(khachHang);
            cart.setChiTietSanPham(chiTietSanPham);
            cart.setSoLuong(quantity);
            cart.setDonGia(chiTietSanPham.getGiaBan());
            cart.setTrangThai(0);
            cartService.add(cart);
        }

        return "redirect:/user/cart";
    }

    @GetMapping("user/delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        GioHang gioHang = cartService.getById(id);
        cartService.delete(gioHang);
        return "redirect:/user/cart";
    }
}
