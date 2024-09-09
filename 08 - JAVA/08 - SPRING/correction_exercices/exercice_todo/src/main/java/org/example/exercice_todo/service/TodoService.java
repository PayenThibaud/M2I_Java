package org.example.exercice_todo.service;

import org.example.exercice_todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoService(){
        this.todos.add(new Todo("test1", "description1", true));
        this.todos.add(new Todo("test2", "description2", false));
        this.todos.add(new Todo("test3", "description3", true));
    }

    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo getTodo(){
        return new Todo("test4", "description4", true);
    }
}
