package com.example.sping_portfolio.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

//import models.ImageInfo_Model.java;

@Controller
public class MainController {

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
     /*  List<ImageInfo_Model> imageInfoList = new ArrayList<>();
        String image0 = "http://localhost:8080/images/kira.PNG";
        ImageInfo_Model if0 = new ImageInfo_Model(image0); if0.getOriginalImg(); if0.getGrayscaleImg();
        imageInfoList.add(if0);

        String image1 = "http://localhost:8080/images/natasha.png";
        ImageInfo_Model if1 = new ImageInfo_Model(image1); if1.getOriginalImg(); if1.getGrayscaleImg();
        imageInfoList.add(if1);


        model.addAttribute("iiList", imageInfoList); */

        return "aboutus";

    }

    @GetMapping("/greet")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "minilabs/greet";
    }

    @GetMapping("/birds")
    public String birds() {

        return "minilabs/birds";
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
    public String binary(@RequestParam(name = "bit", required = false, defaultValue = "8") String bit, Model model) {
        model.addAttribute( "bit", bit);
        int newbit = Integer.valueOf(bit);
        model.addAttribute("newbit", newbit);
        return "minilabs/binary";

    }

    @GetMapping("/")
    public String notificationString(@RequestParam(name="name", required=false, defaultValue="World") String name, String email, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        model.addAttribute("name", email); // MODEL is passed to html
        return "index"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/profile")
    public String profile() {

        return "profile";
    }

    @GetMapping("/unitone")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Human") String name,
                           @RequestParam(name="animal", required=false, defaultValue="Animal") String animal,
                           @RequestParam(name="number1", required=false, defaultValue="3") String number1,
                           @RequestParam(name="number2", required=false, defaultValue="2") String number2, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("animal", animal);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        int result = Integer.valueOf(number1) * Integer.valueOf(number2) ;
        model.addAttribute("result", result);
        return "minilabs/unitone";

    }
}