package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Scanner;

@Controller
public class UnitOne {
    @GetMapping("/unitone")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Human") String name,
                           @RequestParam(name="animal", required=false, defaultValue="Animal") String animal,
                           @RequestParam(name="number1", required=false, defaultValue="3") String number1,
                           @RequestParam(name="number2", required=false, defaultValue="2") String number2, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("animal", animal);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "unitone";

    }

}
