package com.technomad.scpv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping("hello/{name:}")
    public String helloMessage(@PathVariable String name) {
        return "hello " + name;
    }
}
