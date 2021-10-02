package com.example.sping_portfolio.algorithm;

import com.example.sping_portfolio.algorithm.catalanModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class CatalanController {

    public List<com.example.sping_portfolio.algorithm.catalanModel._Catalan> catInit(int nth) {
        //Fibonacci objects created with different initializers
        List<com.example.sping_portfolio.algorithm.catalanModel._Catalan> catList = new ArrayList<>();
        catList.add(new CatFor(nth));
        catList.add(new CatWhile(nth));
        catList.add(new CatRecurse(nth));
        catList.add(new CatStream(nth));

        return catList;
    }

    // GET request,, parameters are passed within the URI
    @GetMapping("/cat")
    public String cat(@RequestParam(name="catseq", required=false,  defaultValue="2") String catseq, Model model) {
        //nth is fibonacci request
        int nth = Integer.parseInt(catseq);

        //MODEL attributes are passed back html
        model.addAttribute("catList", catInit(nth));

        return "algorithm/cat"; //HTML render fibonacci results

    }

    // Console UI is run out of the same Controller
    public static void main(String[] args) {
        int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

        List<com.example.sping_portfolio.algorithm.catalanModel._Catalan> catList = new CatalanController().catInit(nth);
        for (com.example.sping_portfolio.algorithm.catalanModel._Catalan catalan : catList)
            catalan.print();  //Console output fibonacci results
    }
}