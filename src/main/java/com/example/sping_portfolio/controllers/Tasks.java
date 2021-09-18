package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.ArrayList;

@Controller
public class Tasks implements Serializable {
    String title;
    String description;
    Boolean complete;

    public void taskAssign(String t, String d) {
        title = t;
        description = d;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public ArrayList<Tasks> taskslist(){
        Tasks task1 = new Tasks();//creating an object of Student
        Tasks task2 = new Tasks();
        task1.taskAssign( "Math homework", "DO YOUR MATH!!!!!");
        task2.taskAssign( "English Homework", "Write a whole essay boyyyyy");

        ArrayList<Tasks> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);

        return (list);
    }


    public static void main(String[] args) {
        //Creating an object or instance

    }


    @GetMapping("/tasks")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String tasks(@RequestParam(name="title", required=false, defaultValue="Task title") String title,
                        @RequestParam(name="description", required=false, defaultValue="Task description") String description,
                        Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        //model.addAttribute("list", taskslist());

        Tasks task10 = new Tasks();
        task10.taskAssign(title, description);

        Tasks task1 = new Tasks();//creating an object of Student
        Tasks task2 = new Tasks();
        Tasks task3 = new Tasks();
        Tasks task4 = new Tasks();//creating an object of Student
        Tasks task5 = new Tasks();
        Tasks task6 = new Tasks();
        Tasks task7 = new Tasks();//creating an object of Student
        Tasks task8 = new Tasks();
        Tasks task9 = new Tasks();

        task1.taskAssign("Math homework", "DO YOUR MATH!!!!!");
        task2.taskAssign("English Homework", "Write a whole essay");
        task3.taskAssign("CompSci Homework", "Doing it right now :)");
        task1.taskAssign("Math homework", "DO YOUR MATH!!!!!");
        task2.taskAssign("English Homework", "Write a whole essay");
        task3.taskAssign("CompSci Homework", "Doing it right now :)");
        task1.taskAssign("Math homework", "DO YOUR MATH!!!!!");
        task2.taskAssign("English Homework", "Write a whole essay");
        task3.taskAssign("CompSci Homework", "Doing it right now :)");


        ArrayList<Tasks> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);
        list.add(task5);
        list.add(task6);
        list.add(task7);
        list.add(task8);
        list.add(task9);
        list.add(task10);
        model.addAttribute("list", list);

        return "tasks"; // returns HTML VIEW (greeting)

    }


}


