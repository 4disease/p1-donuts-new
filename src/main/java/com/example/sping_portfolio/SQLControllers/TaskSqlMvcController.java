package com.example.sping_portfolio.SQLControllers;

import com.example.sping_portfolio.model.SQL.Login;
import com.example.sping_portfolio.model.SQL.Task;
import com.example.sping_portfolio.model.SQL.TaskSqlRepository;
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
public class TaskSqlMvcController implements WebMvcConfigurer {
    @Autowired
    private TaskSqlRepository repository;

    @GetMapping("/data/task")
    public String task(Model model) {
        List<Task> task = repository.listAll();
        model.addAttribute("task", task);
        return "data/task";
    }

    @GetMapping("/data/createtask")
    public String taskAdd(Task task) {
        return "data/createtask";
    }

    @PostMapping("/data/createtask")
    public String taskSave(@Valid Task task, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "data/createtask";
        }
        repository.save(task);
        // Redirect to next step
        return "redirect:/data/task";
    }

}
