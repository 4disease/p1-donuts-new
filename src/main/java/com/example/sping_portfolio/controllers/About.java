package com.example.sping_portfolio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class About {
    @GetMapping("/about")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String about() {
        return "about"; // returns HTML VIEW (greeting)
    }
}
