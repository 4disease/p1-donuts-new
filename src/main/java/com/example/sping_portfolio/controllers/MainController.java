package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/aboutus")
    public String aboutus() { return "aboutus";
    }

    @GetMapping("/greet")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greet";
    }

    @GetMapping("/birds")
    public String birds() {
        return "birds";
    }

    @GetMapping("/adi")
    public String adi() {
        return "/minilabs/adi";
    }

    @GetMapping("/kira")
    public String kira(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "/minilabs/kira";
    }

    @GetMapping("/natasha")
    public String natasha(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "/minilabs/natasha";
    }

    @GetMapping("/ridhima")
    public String ridhima() {
        return "/minilabs/ridhima";
    }

    @GetMapping("/sam")
    public String sam() {
        return "/minilabs/sam";
    }

    @GetMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

    @GetMapping("/chatbot")
    public String chatbot() {
        return "/chatbot";
    }

    @GetMapping("/binary")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String binary(@RequestParam(name = "bit", required = false, defaultValue = "8") String bit,
                         @RequestParam(name = "decimal", required = false, defaultValue = "0") String decimal, Model model) {
        model.addAttribute( "bit", bit);
        int newbit = Integer.valueOf(bit);
        model.addAttribute("newbit", newbit);
        int decimalValue = 57;
        char asciiValue = (char) decimalValue;
        model.addAttribute("asciiValue", asciiValue);
        return "binary";

    }

}
