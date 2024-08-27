package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exam")
    private int id;
    private LocalDate date;
    private float grade;
    private String subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Student student;
}
