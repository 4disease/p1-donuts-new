package com.example.sping_portfolio.minilabs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

    public class Syllabus {

    public void checkSign(String student, String parent, boolean signed) {
        if (signed) {
            System.out.println("Student name: " + student);
            System.out.println("Parent name: " + parent);
            System.out.println("Syllabus is signed.");
        } else {
            System.out.println("Student name: " + student);
            System.out.println("Parent name: " + parent);
            System.out.println("Syllabus is not signed.");
        }

    }

    public static void main(String[] args) {
        Syllabus newSyllabus = new Syllabus();
        newSyllabus.checkSign("Bob", "Bobby", true);
        newSyllabus.checkSign("Joe", "Joey", false);

    }

    @GetMapping("/classminilab")
    public String greeting(@RequestParam(name = "studentname", required = false, defaultValue = "World") String studentname,
                           @RequestParam(name = "parentname", required = false, defaultValue = "Parent") String parentname,
                           @RequestParam(name = "signed", required = false) Boolean signed, Model model) {
        model.addAttribute("studentname", studentname);
        model.addAttribute("parentname", parentname);
        model.addAttribute("signed", signed);
        Syllabus newSyllabus = new Syllabus();
        newSyllabus.checkSign(studentname, parentname, signed);
        return "classminilab"; // returns HTML VIEW (greeting)
    }
}

//use a class
//have 3 parameters, one if else statement
//strong scenario
//call class and procedure at least twice


