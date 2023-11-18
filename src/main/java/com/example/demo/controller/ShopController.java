package com.example.demo.controller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.GioHang;
import com.example.demo.service.CartService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductPagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class ShopController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductPagingService productPagingService;

    private List<GioHang> listGioHang = new ArrayList<>();
    private List<DanhMuc> listDanhMuc = new ArrayList<>();

    @GetMapping("home")
    public String hienThi(Model model,  @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "6") int size) {
        listGioHang = cartService.getAllByTrangThai();
        listDanhMuc = categoryService.getAll();
        int countCart = listGioHang.size();
        model.addAttribute("page", page);
        Pageable pageable = PageRequest.of(page, size);
        Page<ChiTietSanPham> pageCTSP = productPagingService.findAllByTrangThai(1, pageable);
        model.addAttribute("countCart", countCart);
        model.addAttribute("listDM", listDanhMuc);
        model.addAttribute("data", pageCTSP);
        return "common/shop";
    }

    @GetMapping("home-asc")
    public String sortAsc(Model model,  @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "6") int size) {
        listGioHang = cartService.getAllByTrangThai();
        listDanhMuc = categoryService.getAll();
        int countCart = listGioHang.size();
        model.addAttribute("page", page);
        Pageable pageable = PageRequest.of(page, size);
        Page<ChiTietSanPham> pageCTSP = productPagingService.findAllByTrangThaiOrderByGiaBanAsc(1, pageable);
        model.addAttribute("countCart", countCart);
        model.addAttribute("listDM", listDanhMuc);
        model.addAttribute("data", pageCTSP);
        return "common/shop";
    }

    @GetMapping("home-desc")
    public String sortDesc(Model model,  @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "6") int size) {
        listGioHang = cartService.getAllByTrangThai();
        listDanhMuc = categoryService.getAll();
        int countCart = listGioHang.size();
        model.addAttribute("page", page);
        Pageable pageable = PageRequest.of(page, size);
        Page<ChiTietSanPham> pageCTSP = productPagingService.findAllByTrangThaiOrderByGiaBanDesc(1, pageable);
        model.addAttribute("countCart", countCart);
        model.addAttribute("listDM", listDanhMuc);
        model.addAttribute("data", pageCTSP);
        return "common/shop";
    }

}
