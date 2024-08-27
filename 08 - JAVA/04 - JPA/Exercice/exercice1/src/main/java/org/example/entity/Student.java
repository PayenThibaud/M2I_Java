package org.example.entity;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id;
    private String firstname;
    private String lastname;
    private String classe;

    @Embedded
    private Adress adress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Exam> exams ;

    @ManyToMany(mappedBy = "students")
    private List<Cours> cours;

    public Student() {
        exams = new ArrayList<>();
        cours = new ArrayList<>();
    }
}
