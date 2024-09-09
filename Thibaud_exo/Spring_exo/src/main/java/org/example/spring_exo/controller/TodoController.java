package org.example.spring_exo.controller;

import org.example.spring_exo.model.Todo;
import org.example.spring_exo.service.ServiceTodo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    private final ServiceTodo serviceTodo;

    public TodoController(ServiceTodo serviceTodo) {
        this.serviceTodo = serviceTodo;
    }

    @RequestMapping("/todo")
    public String getOneTodo(Model model) {
        model.addAttribute("Todo", serviceTodo.getFirstTodo());
        return "todo";
    }

    @RequestMapping("/todos")
    public String getAllTodos(Model model) {
        serviceTodo.getAllTodo();
        model.addAttribute("Todos", serviceTodo.getAllTodo());
        return "todos";
    }

    @RequestMapping("/index")
    public String home() {
        return "index";
    }
}
