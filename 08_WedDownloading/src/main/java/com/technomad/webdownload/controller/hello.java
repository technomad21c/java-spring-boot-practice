package com.technomad.webdownload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping("hello/{name}")
    public String helloMessage(@PathVariable String name) {
        return "hello " + name;
    }

    @GetMapping("/web")
    public    String loginMessage() {
        return "Welcome";
    }
}
