package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.ArrayList;

@Controller
public class Tasks implements Serializable {

    int id;
    String title;
    String description;
    Boolean complete;

    public void taskAssign(int i, String t, String d, Boolean c) {
        id = i;
        title = t;
        description = d;
        complete = c;
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
        task1.taskAssign(1, "Math homework", "DO YOUR MATH!!!!!", false);
        task2.taskAssign(2, "English Homework", "Write a whole essay boyyyyy", false);

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
    public String tasks(Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        //model.addAttribute("list", taskslist());

        Tasks task1 = new Tasks();//creating an object of Student
        Tasks task2 = new Tasks();
        Tasks task3 = new Tasks();
        Tasks task4 = new Tasks();//creating an object of Student
        Tasks task5 = new Tasks();
        Tasks task6 = new Tasks();
        Tasks task7 = new Tasks();//creating an object of Student
        Tasks task8 = new Tasks();
        Tasks task9 = new Tasks();

        task1.taskAssign(1, "Math homework", "DO YOUR MATH!!!!!", false);
        task2.taskAssign(2, "English Homework", "Write a whole essay", false);
        task3.taskAssign(3, "CompSci Homework", "Doing it right now :)", false);
        task4.taskAssign(4, "Math homework", "DO YOUR MATH!!!!!", false);
        task5.taskAssign(5, "English Homework", "Write a whole essay", false);
        task6.taskAssign(6, "CompSci Homework", "Doing it right now :)", false);
        task7.taskAssign(7, "Math homework", "DO YOUR MATH!!!!!", false);
        task8.taskAssign(8, "English Homework", "Write a whole essay", false);
        task9.taskAssign(9, "CompSci Homework", "Doing it right now :)", false);

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
        model.addAttribute("list", list);

        return "tasks"; // returns HTML VIEW (greeting)

    }


}


