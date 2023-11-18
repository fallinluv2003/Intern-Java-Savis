package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("account", new Account());
        return "/common/register";
    }

    @PostMapping("sign-up")
    public String signUp(@ModelAttribute("account") Account account) {
        account.setNgayTao(new Date());
        account.setTrangThai(0);
        accountService.add(account);
        return "redirect:/register";
    }
}
