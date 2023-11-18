package com.example.demo.controller;

import com.example.demo.entity.Brand;
import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.Product;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ColorService;
import com.example.demo.service.MaterialService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/product/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private MaterialService materialService;

    private List<ChiTietSanPham> listCTSP = new ArrayList<>();
    private List<Brand> listBrand = new ArrayList<>();
    private List<MauSac> listColor = new ArrayList<>();
    private List<DanhMuc> listCategory = new ArrayList<>();
    private List<ChatLieu> listMaterial = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        listCTSP = productService.getAll();
        listBrand = brandService.getAllByTrangThai();
        listColor = colorService.getAllByTrangThai();
        listCategory = categoryService.getAllByTrangThai();
        listMaterial = materialService.getAllByTrangThai();
        model.addAttribute("product", new ChiTietSanPham());
        model.addAttribute("listProduct", listCTSP);
        model.addAttribute("listBrand", listBrand);
        model.addAttribute("listColor", listColor);
        model.addAttribute("listCategory", listCategory);
        model.addAttribute("listMaterial", listMaterial);
        return "/admin/product";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @ModelAttribute("product") ChiTietSanPham chiTietSanPham) {
        String ma = "";
        ma = "SP" + (listCTSP.size() + 1);
        chiTietSanPham.setMa(ma);
        chiTietSanPham.setTrangThai(1);
        productService.add(chiTietSanPham);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/admin/product/load";
    }

    @PostMapping("update/{id}")
    public String add(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("product") ChiTietSanPham chiTietSanPham) {
        listCTSP = productService.getAll();
        for (ChiTietSanPham ctsp : listCTSP) {
            if (ctsp.getId().equals(id)) {
                ctsp.setMa(chiTietSanPham.getMa());
                ctsp.setTen(chiTietSanPham.getTen());
                ctsp.setBrand(chiTietSanPham.getBrand());
                ctsp.setMauSac(chiTietSanPham.getMauSac());
                ctsp.setDanhMuc(chiTietSanPham.getDanhMuc());
                ctsp.setChatLieu(chiTietSanPham.getChatLieu());
                ctsp.setImage(chiTietSanPham.getImage());
                ctsp.setSoLuong(chiTietSanPham.getSoLuong());
                ctsp.setGiaBan(chiTietSanPham.getGiaBan());
                ctsp.setGiaNhap(chiTietSanPham.getGiaNhap());
                ctsp.setMoTa(chiTietSanPham.getMoTa());
                ctsp.setTrangThai(chiTietSanPham.getTrangThai());
                productService.add(ctsp);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/product/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        listCTSP =  productService.getAll();
        for (ChiTietSanPham chiTietSanPham : listCTSP) {
            if (chiTietSanPham.getId().equals(id)) {
                chiTietSanPham.setTrangThai(0);
                productService.add(chiTietSanPham);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/product/load";
    }
//push san pham
}
