package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/position/")
public class PositonController {
//khai bao
    @Autowired
    private PositionService positionService;

    private List<ChucVu> list = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        list = positionService.getAll();
        model.addAttribute("position", new ChucVu());
        model.addAttribute("listChucVu", list);
        return "/admin/position";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @ModelAttribute("position") ChucVu chucVu) {
        String ma = "";
        ma = "CV" + (list.size() + 1);
        chucVu.setMa(ma);
        chucVu.setNgayTao(new Date());
        chucVu.setNgaySua(new Date());
        chucVu.setTrangThai(1);
        positionService.add(chucVu);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/admin/position/load";
    }

    @PostMapping("update/{id}")
    public String update(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("position") ChucVu chucVu) {
        list = positionService.getAll();
        for (ChucVu cv : list) {
            if (cv.getId().equals(id)) {
                cv.setMa(chucVu.getMa());
                cv.setTen(chucVu.getTen());
                cv.setNgaySua(new Date());
                cv.setTrangThai(chucVu.getTrangThai());
                positionService.add(cv);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/position/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        list =  positionService.getAll();
        for (ChucVu chucVu : list) {
            if (chucVu.getId().equals(id)) {
                chucVu.setTrangThai(0);
                positionService.add(chucVu);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/position/load";
    }

}
