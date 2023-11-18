package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHang;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class DetailProductController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/user/detail/{id}")
    public String detail(Model model, @PathVariable("id") UUID id) {
        List<ChiTietSanPham> chiTietSanPhamList = productService.getAll();
        List<GioHang> gioHangList = cartService.getAllByTrangThai();
        int countCart = gioHangList.size();
        for (ChiTietSanPham chiTietSanPham : chiTietSanPhamList) {
            if (chiTietSanPham.getId().equals(id)) {
                model.addAttribute("productDetail", chiTietSanPham);
            }
        }
        model.addAttribute("countCart", countCart);
        model.addAttribute("product", chiTietSanPhamList);
        return "user/detail";
    }

}
