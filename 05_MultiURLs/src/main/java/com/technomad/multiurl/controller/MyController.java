package com.technomad.multiurl.controller;

import domain.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class MyController {

    @GetMapping(value = {"/employee/{id}", "/employee/{dept}/{name}"})
    public String employee(@PathVariable Optional<String> id, @PathVariable Optional<String> dept, @PathVariable Optional<String> name) {
        Employee e = null;
        String res = null;

        if (id.isPresent()) {
            e = new Employee(id.get(), null);
            res = e.getId();
        }
        if (dept.isPresent() && name.isPresent()) {
            e = new Employee(null, name.get());
            res = e.getName();
        }

        return res;
    }

    @DeleteMapping(path = {"/employee/{id}", "/employee/{dept}/{id}"})
    public String deleteEmployee(@PathVariable Optional<String> id, @PathVariable Optional<String> dept) {
        Employee e = null;
        String res = null;

        if (id.isPresent()) {
            e = new Employee(id.get(), null);

            res = e.getId();
        }
        if (dept.isPresent()) {
            e = new Employee(null, dept.get());
            res = e.getName();
        }

        return "delete" + res;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
