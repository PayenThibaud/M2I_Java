package org.example.spring_exo.controller;

import org.example.spring_exo.model.Todo;
import org.example.spring_exo.service.ServiceTodo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {

    private final ServiceTodo serviceTodo;

    public TodoController(ServiceTodo serviceTodo) {
        this.serviceTodo = serviceTodo;
    }

    @RequestMapping("/todo/{nb}")
    public String getOneTodo(Model model, @PathVariable("nb") int nb) {
        model.addAttribute("Todo", serviceTodo.getTodo(nb));
        return "todo";
    }

    @RequestMapping("/todos")
    public String getAllTodos(Model model) {
        model.addAttribute("Todos", serviceTodo.getAllTodo());
        return "todos";
    }

    @RequestMapping("/todos-json")
    @ResponseBody
    public List<Todo> getAllTodosJson() {
        return serviceTodo.getAllTodo();
    }

    @RequestMapping("/index")
    public String home() {
        return "index";
    }
}
