package com.example.sping_portfolio.minilabs;
//import com.nighthawk.csa.algorithm.fibonacciModel.*;
//import com.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class perrincontrol {
    public List<_Perrin> perInit(int nth) {
        //Perrin objects created with different initializers
        List<_Perrin> PerrinList = new ArrayList<>();
        PerrinList.add(new PerrinFor(nth));
        PerrinList.add(new PerrinWhile(nth));
        PerrinList.add(new PerrinRecurse(nth));
        PerrinList.add(new PerrinStream(nth));

        return PerrinList;
    }

    // GET request,, parameters are passed within the URI
    @GetMapping("/perrin")
    public String perrin(@RequestParam(name="perseq", required=false,  defaultValue="2") String perseq, Model model) {
        //nth is fibonacci request
        int nth = Integer.parseInt(perseq);

        //MODEL attributes are passed back html
        model.addAttribute("PerrinList", perInit(nth));

        return "algorithm/perrin"; //HTML render fibonacci results

    }

    // Console UI is run out of the same Controller
    public static void main(String[] args) {
        int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

        List<_Perrin> fibList = new perrincontrol().perInit(nth);
        for (_Perrin fibonacci : fibList)
            fibonacci.print();  //Console output fibonacci results
    }
}
