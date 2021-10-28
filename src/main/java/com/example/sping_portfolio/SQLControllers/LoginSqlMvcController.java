package com.example.sping_portfolio.SQLControllers;

import com.example.sping_portfolio.model.SQL.Login;
import com.example.sping_portfolio.model.SQL.LoginSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginSqlMvcController implements WebMvcConfigurer {
    @Autowired
    private LoginSqlRepository repository;

    @GetMapping("/data/login")
    public String person(Model model) {
        List<Login> list = repository.listAll();
        model.addAttribute("list", list);
        return "data/login";
    }

    @GetMapping("/data/createlogin")
    public String loginAdd(Login login) {
        return "data/createlogin";
    }

    @PostMapping("/data/createlogin")
    public String loginSave(@Valid Login login, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "data/createlogin";
        }
        repository.save(login);
        // Redirect to next step
        return "redirect:/data/login";
    }
}
