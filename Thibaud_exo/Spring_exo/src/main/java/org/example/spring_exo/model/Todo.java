package org.example.spring_exo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data

public class Todo {
    private String name;
    private String description;
    private boolean isDone;

    public Todo(String name, String description, boolean isDone) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }
}
