package com.example.demo.controller;

import com.example.demo.entity.DanhMuc;
import com.example.demo.service.CategoryService;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private List<DanhMuc> list = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        list = categoryService.getAll();
        model.addAttribute("category", new DanhMuc());
        model.addAttribute("listCategory", list);
        return "/admin/category";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @ModelAttribute("category") DanhMuc danhMuc) {
        String ma = "";
        ma = "DM" + (list.size() + 1);
        danhMuc.setMa(ma);
        danhMuc.setNgayTao(new Date());
        danhMuc.setNgaySua(new Date());
        danhMuc.setTrangThai(1);
        categoryService.add(danhMuc);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/admin/category/load";
    }

    @PostMapping("update/{id}")
    public String update(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("category") DanhMuc danhMuc) {
        list = categoryService.getAll();
        for (DanhMuc dm : list) {
            if (dm.getId().equals(id)) {
                dm.setMa(danhMuc.getMa());
                dm.setTen(danhMuc.getTen());
                dm.setNgaySua(new Date());
                dm.setTrangThai(danhMuc.getTrangThai());
                categoryService.add(dm);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/category/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        list = categoryService.getAll();
        for (DanhMuc danhMuc : list) {
            if (danhMuc.getId().equals(id)) {
                danhMuc.setTrangThai(0);
                categoryService.add(danhMuc);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/category/load";
    }

}
