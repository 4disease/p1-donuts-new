package com.example.sping_portfolio.algorithm;

import com.example.sping_portfolio.algorithm.pellModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class PellController {

    public List<com.example.sping_portfolio.algorithm.pellModel._Pell> pellInit(int nth) {
        //Fibonacci objects created with different initializers
        List<com.example.sping_portfolio.algorithm.pellModel._Pell> pellList = new ArrayList<>();
        pellList.add(new PellFor(nth));
        pellList.add(new PellWhile(nth));
        pellList.add(new PellRecurse(nth));
        pellList.add(new PellStream(nth));

        return pellList;
    }

    // GET request,, parameters are passed within the URI
    @GetMapping("/pell")
    public String pell(@RequestParam(name="pellseq", required=false,  defaultValue="2") String pellseq, Model model) {
        //nth is fibonacci request
        int nth = Integer.parseInt(pellseq);

        //MODEL attributes are passed back html
        model.addAttribute("pellList", pellInit(nth));

        return "algorithm/pell"; //HTML render fibonacci results

    }

    // Console UI is run out of the same Controller
    public static void main(String[] args) {
        int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

        List<com.example.sping_portfolio.algorithm.pellModel._Pell> pellList = new PellController().pellInit(nth);
        for (com.example.sping_portfolio.algorithm.pellModel._Pell pell : pellList)
            pell.print();  //Console output fibonacci results
    }
}