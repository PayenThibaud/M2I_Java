package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cours")
    private int id;
    private String subject;
    private String teacher;
    private String room;
    private LocalDateTime hours;

    @ManyToMany
    @JoinTable(name = "vours_student",
            joinColumns = @JoinColumn(name = "id_cours"),
            inverseJoinColumns = @JoinColumn(name="id_student"))
    private List<Student> students;

    public Cours() {
        students = new ArrayList<>();
    }

    public void add (Student student){
        students.add(student);
    }
}
