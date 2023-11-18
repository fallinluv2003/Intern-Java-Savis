package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.service.ColorService;
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
@RequestMapping("/admin/color/")
public class ColorController {

    @Autowired
    private ColorService colorService;

    private List<MauSac> list = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        list = colorService.getAll();
        model.addAttribute("color", new MauSac());
        model.addAttribute("listColor", list);
        return "/admin/color";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @ModelAttribute("color") MauSac mauSac) {
        String ma = "";
        ma = "M" + (list.size() + 1);
        mauSac.setMa(ma);
        mauSac.setNgayTao(new Date());
        mauSac.setNgaySua(new Date());
        mauSac.setTrangThai(1);
        redirectAttributes.addFlashAttribute(mauSac);
        return "redirect:/admin/color/load";
    }

    @PostMapping("update/{id}")
    public String update(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("color") MauSac mauSac) {
        list = colorService.getAll();
        for (MauSac ms : list) {
            if (ms.getId().equals(id)) {
                ms.setMa(mauSac.getMa());
                ms.setTen(mauSac.getTen());
                ms.setNgaySua(new Date());
                ms.setTrangThai(mauSac.getTrangThai());
                colorService.add(ms);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/color/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        list =  colorService.getAll();
        for (MauSac mauSac : list) {
            if (mauSac.getId().equals(id)) {
                mauSac.setTrangThai(0);
                colorService.add(mauSac);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/color/load";
    }

}
