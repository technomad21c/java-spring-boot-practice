package com.example.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "John Doe");
        return "index";
    }
}
