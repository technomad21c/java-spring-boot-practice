package com.technomad.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private Environment env;

    @GetMapping("/hello/test")
    public String test1(Model model) {
        logger.debug("TEST /hello/test");
        return "TEST /hello/test";
    }

    @GetMapping("/hello")
    public String test2() {
        List<String> data = Arrays.asList("one", "two", "three");
        logger.debug("Hello from Logback {}", data);

        return "TEST /hello";
    }

    @GetMapping("/")
    public String hello() {
        logger.debug("TEST /");

        return "TEST /";
    }


}
