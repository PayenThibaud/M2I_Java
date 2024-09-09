package org.example.exercice_todo.controller;

import org.example.exercice_todo.model.Todo;
import org.example.exercice_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/alltodos")
    @ResponseBody
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @RequestMapping("/todo")
    public String getOneTodo(Model model){
        model.addAttribute("todo", todoService.getTodo());
        return "todo";
    }
}
