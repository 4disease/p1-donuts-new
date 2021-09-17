package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Notification {
@GetMapping("/")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
public String notificationString(@RequestParam(name="name", required=false, defaultValue="World") String name, String email, Model model) {
    // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
    model.addAttribute("name", name); // MODEL is passed to html
    model.addAttribute("name", email); // MODEL is passed to html
    return "index"; // returns HTML VIEW (greeting)
}
}

