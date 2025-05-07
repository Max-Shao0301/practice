package com.user.controller;

import com.user.model.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage(Model model) {
        return "login";
    }


    @PostMapping("/login/check")
    public String login(@RequestParam String account, @RequestParam String password, Model model, HttpSession session) {
        if (userService.check(account, password)) {
            session.setAttribute("isLogin", true );
            return "redirect:/index";
        } else {
            model.addAttribute("errorLogin", "帳號或密碼錯誤");
            return "login";
        }
    }
}
