package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.MauSac;
import com.example.demo.service.MaterialService;
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
@RequestMapping("/admin/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    private List<ChatLieu> list = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        list = materialService.getAll();
        model.addAttribute("material", new ChatLieu());
        model.addAttribute("listMaterial", list);
        return "/admin/material";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @ModelAttribute("material") ChatLieu chatLieu) {
        String ma = "";
        ma = "CL" + (list.size() + 1);
        chatLieu.setMa(ma);
        chatLieu.setNgayTao(new Date());
        chatLieu.setNgaySua(new Date());
        chatLieu.setTrangThai(1);
        materialService.add(chatLieu);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/admin/material/load";
    }

    @PostMapping("update/{id}")
    public String update(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("material") ChatLieu chatLieu) {
        list = materialService.getAll();
        for (ChatLieu cl : list) {
            if (cl.getId().equals(id)) {
                cl.setMa(chatLieu.getMa());
                cl.setTen(chatLieu.getTen());
                cl.setNgaySua(new Date());
                cl.setTrangThai(chatLieu.getTrangThai());
                materialService.add(cl);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/material/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        list =  materialService.getAll();
        for (ChatLieu chatLieu : list) {
            if (chatLieu.getId().equals(id)) {
                chatLieu.setTrangThai(0);
                materialService.add(chatLieu);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/material/load";
    }

}
