package com.example.sping_portfolio.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.swing.text.html.HTMLDocument;
import javax.validation.constraints.DecimalMax;
import java.io.IOException;

//import com.example.sping_portfolio.controllers.ImageInfo_Model.java;

@Controller
public class MainController {

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
    //    String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/1200px-Abraham_Lincoln_O-77_matte_collodion_print.jpg";
      //  ImageInfo_Model ai = new ImageInfo_Model(url);
        //String[] rows = ai.pixelgrayscale();
        //model.addAttribute("rows", rows);

        return "aboutus";

    }

    @GetMapping("/greet")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greet";
    }

    @GetMapping("/birds")
    public String birds() {
        return "birds";
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
        return "binary";

    }

    /* @GetMapping("/image")
    public String image(Model model) throws IOException {
        String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/1200px-Abraham_Lincoln_O-77_matte_collodion_print.jpg";
        ImageInfo ai = new ImageInfo();
        String[] rows = ai.convert_to_ascii();
        model.addAttribute("rows", rows);
        return "minilabs/image";
    }
    */
}