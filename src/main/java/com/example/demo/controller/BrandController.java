package com.example.demo.controller;

import com.example.demo.entity.Brand;
import com.example.demo.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/admin/brand/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    private List<Brand> list = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        list = brandService.getAll();
        model.addAttribute("brand", new Brand());
        model.addAttribute("listBrand", list);
        return "/admin/brand";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @Valid @ModelAttribute("brand") Brand brand) {
        String ma = "";
        ma = "B" + (list.size() + 1);
        brand.setMa(ma);
        brand.setNgayTao(new Date());
        brand.setNgaySua(new Date());
        brand.setTrangThai(1);
        brandService.add(brand);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/admin/brand/load";
    }

    @PostMapping("update/{id}")
    public String update(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("brand") Brand brand) {
        list = brandService.getAll();
        for (Brand br : list) {
            if (br.getId().equals(id)) {
                br.setMa(brand.getMa());
                br.setTen(brand.getTen());
                br.setNgaySua(new Date());
                br.setTrangThai(brand.getTrangThai());
                brandService.add(br);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/brand/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        list = brandService.getAll();
        for (Brand brand : list) {
            if (brand.getId().equals(id)) {
                brand.setTrangThai(0);
                brandService.add(brand);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/brand/load";
    }

}
