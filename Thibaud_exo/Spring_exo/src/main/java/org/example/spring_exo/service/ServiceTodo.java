package org.example.spring_exo.service;

import org.example.spring_exo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTodo {

    private List<Todo> todos;

    public ServiceTodo() {
        todos = new ArrayList<>();

        Todo todo1 = new Todo("Apprendre Java", "Suivre des cours sur Java", true);
        Todo todo2 = new Todo("Faire les courses", "Acheter des fruits et légumes", false);
        Todo todo3 = new Todo("Préparer un projet", "Commencer le projet Spring Boot", true);

        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }

    public Todo getFirstTodo(){
    return todos.get(0);
    }


    public List<Todo> getAllTodo(){
    return todos;
    }
}
