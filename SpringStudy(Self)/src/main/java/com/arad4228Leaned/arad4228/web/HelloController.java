package com.arad4228Leaned.arad4228.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello";
    }
}
