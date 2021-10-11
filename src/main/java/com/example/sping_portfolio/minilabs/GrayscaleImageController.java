/*package com.example.sping_portfolio.minilabs;
import com.example.sping_portfolio.minilabs.geometricModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class GrayscaleImageController {


        public List<_Geometric> geoInit(int nth) {
            //Fibonacci objects created with different initializers
            List<_Geometric> geoList = new ArrayList<>();
            geoList.add(new GeoFor(nth));
            geoList.add(new GeoWhile(nth));
            geoList.add(new GeoRecurse(nth));
            geoList.add(new GeoStream(nth));

            return geoList;
        }

        // GET request,, parameters are passed within the URI
        @GetMapping("/geometric")
        public String fib(@RequestParam(name="geoseq", required=false,  defaultValue="2") String geoseq, Model model) {
            //nth is fibonacci request
            int nth = Integer.parseInt(geoseq);

            //MODEL attributes are passed back html
            model.addAttribute("geoList", geoInit(nth));

            return "/minilabs/geometric"; //HTML render fibonacci results

        }

        // Console UI is run out of the same Controller
        public static void main(String[] args) {
            int nth = 20; //!!!make dynamic using consoleUI inputInt!!! 92 is max for long

            List<_Geometric> geoList = new com.example.sping_portfolio.minilabs.GeometricController().geoInit(nth);
            for (_Geometric geometric : geoList)
                geometric.print();  //Console output fibonacci results

    } */
