package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;

    private List<NhanVien> listNhanVien = new ArrayList<>();
    private List<ChucVu> listChucVu = new ArrayList<>();

    @GetMapping("load")
    public String hienThi(Model model) {
        listNhanVien = employeeService.getAll();
        listChucVu = positionService.getAllByTrangThai();
        model.addAttribute("employee", new NhanVien());
        model.addAttribute("listNhanVien", listNhanVien);
        model.addAttribute("listChucVu", listChucVu);
        return "/admin/employee";
    }

    @PostMapping("add")
    public String add(RedirectAttributes redirectAttributes, @ModelAttribute("employee") NhanVien nhanVien) {
        String ma = "";
        ma = "NV" + (listNhanVien.size() + 1);
        nhanVien.setMa(ma);
        nhanVien.setTrangThai(1);
        employeeService.add(nhanVien);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/admin/employee/load";
    }

    @PostMapping("update/{id}")
    public String update(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id, @ModelAttribute("employee") NhanVien nhanVien) {
        listNhanVien = employeeService.getAll();
        for (NhanVien nv : listNhanVien) {
            if (nv.getId().equals(id)) {
                nv.setMa(nhanVien.getMa());
                nv.setTen(nhanVien.getTen());
                nv.setTenDem(nhanVien.getTenDem());
                nv.setHo(nhanVien.getHo());
                nv.setGioiTinh(nhanVien.getGioiTinh());
                nv.setNgaySinh(nhanVien.getNgaySinh());
                nv.setDiaChi(nhanVien.getDiaChi());
                nv.setSdt(nhanVien.getSdt());
                nv.setChucVu(nhanVien.getChucVu());
                nv.setTrangThai(nhanVien.getTrangThai());
                employeeService.add(nv);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/admin/employee/load";
    }

    @GetMapping("delete/{id}")
    public String updateTrangThai(RedirectAttributes redirectAttributes, @PathVariable("id") UUID id) {
        listNhanVien =  employeeService.getAll();
        for (NhanVien nhanVien : listNhanVien) {
            if (nhanVien.getId().equals(id)) {
                nhanVien.setTrangThai(0);
                employeeService.add(nhanVien);
            }
        }
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/admin/employee/load";
    }

}
