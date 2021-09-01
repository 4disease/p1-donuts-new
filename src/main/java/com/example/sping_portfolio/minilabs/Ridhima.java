package com.example.sping_portfolio.minilabs;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Ridhima {

    @GetMapping("/ridhima")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "ridhima"; // returns HTML VIEW (greeting)
    }

    @GetMapping("/ridhima")
    public String greeting(@RequestParam(school="school", required=false, defaultValue="World") String school, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("school", school); // MODEL is passed to html
        return "ridhima"; // returns HTML VIEW (greeting)
    }


}
